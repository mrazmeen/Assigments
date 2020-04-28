package com.carsale.userservice.service;

import com.carsale.userservice.configuration.URLConfiguration;
import com.carsale.userservice.exceptionhandler.ResourceNotFoundException;
import com.carsale.userservice.exceptionhandler.RestTemplateResponseErrorHandler;
import com.carsale.userservice.model.APIResponse;
import com.carsale.userservice.model.AccessToken;
import com.carsale.userservice.model.Role;
import com.carsale.userservice.model.User;
import com.carsale.userservice.repository.RoleRepository;
import com.carsale.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.http.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Value("${authserver.clientid}")
    private String clientID;
    @Value("${authserver.clintsecret}")
    private String clientSecret;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public BCryptPasswordEncoder getbCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private RestTemplateResponseErrorHandler restTemplateResponseErrorHandler;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getAllUsersByEmail(String email) {
        User user = new User();
        user.setEmail(email);

        Example<User> userExample = Example.of(user);
        return userRepository.findAll(userExample);
    }

    @Override
    public User getUserByUsername(String username) {

        return userRepository.findByUsername(username);
    }

    @Override
    public ResponseEntity<User> getUserById(Integer userId) throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User Not Found for this ID : " + userId));

        return ResponseEntity.ok().body(user);
    }

    @Override
    public User createUser(User user) {
//        Role userRole = roleRepository.findByName("ROLE_USER");
        Role userRole = roleRepository.findByName("ROLE_operator");

        User updateUser = new User();
        updateUser.setFirtstName(user.getFirtstName());
        updateUser.setLastName(user.getLastName());
        updateUser.setEmail(user.getEmail());
        updateUser.setUsername(user.getUsername());
        updateUser.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        updateUser.setContactNo(user.getContactNo());

        List<Role> roleList = new ArrayList<>();
        roleList.add(userRole);

        updateUser.setRoles(roleList);
        updateUser.setDateJoined(new Timestamp(System.currentTimeMillis()));
        updateUser.setStatus("A");
        updateUser.setEnabled(Boolean.TRUE);
        updateUser.setAccountNonExpired(Boolean.TRUE);
        updateUser.setCredentialsNonExpired(Boolean.TRUE);
        updateUser.setAccountNonLocked(Boolean.TRUE);

        return userRepository.save(updateUser);
    }

    @Override
    public ResponseEntity<User> updateUser(Integer userId, User user) {
        Optional<User> currentUser = userRepository.findById(userId);

        if (currentUser.isPresent()) {
            User updateUser = currentUser.get();
            updateUser.setFirtstName(user.getFirtstName());
            updateUser.setLastName(user.getLastName());
            updateUser.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            updateUser.setContactNo(user.getContactNo());

            User updatedUser = userRepository.save(updateUser);

            return ResponseEntity.ok(updatedUser);
        } else {
            return null;
        }
    }

    @Override
    public Map<String, Boolean> deleteUser(Integer userId) throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User Not Found for this ID : " + userId));

        userRepository.delete(user);

        Map<String, Boolean> response = new HashMap<>();
        response.put("User Deleted", Boolean.TRUE);
        return response;
    }

    @Override
    public APIResponse userLogin(String username, String password) throws ResourceNotFoundException {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        User dbUser = userRepository.findByUsername(username);

        if (dbUser == null) {
            // throw new ResourceNotFoundException("Username or Password is Wrong!"
            return new APIResponse(404, "Username or Password is Wrong!");

        } else {
            if (!bCryptPasswordEncoder.matches(password, dbUser.getPassword())) {
                System.out.println("password not match");
                // throw new ResourceNotFoundException("Username or Password is Wrong!");
                return new APIResponse(404, "Username or Password is Wrong!");
            } else {

                String userRole = "";

                if (dbUser.getRoles().contains("ROLE_operator"))
                    userRole = "U";
                else
                    userRole = "A";

                // Call and get Access Token
                MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
                multiValueMap.add("username", username);
                multiValueMap.add("password", password);
                multiValueMap.add("grant_type", "password");

                HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(multiValueMap, setHeaders());

                ResponseEntity<AccessToken> responseEntity = restTemplate.exchange(
                        URLConfiguration.GET_ACCESS_TOKEN, HttpMethod.POST, httpEntity, AccessToken.class);

                return new APIResponse(200, "Successful!", userRole, responseEntity.getBody());
            }
        }
    }

    @Override
    public APIResponse refreshAccessToken(String refreshToken) {
        // Refresh Access Token
        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.add("grant_type", "refresh_token");
        multiValueMap.add("refresh_token", refreshToken);

        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(multiValueMap, setHeaders());

        restTemplate.setErrorHandler(restTemplateResponseErrorHandler);

        ResponseEntity<AccessToken> responseEntity = restTemplate.exchange(
                URLConfiguration.GET_ACCESS_TOKEN, HttpMethod.POST, httpEntity, AccessToken.class);

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            return new APIResponse(200, "New Token!", responseEntity.getBody());
        } else {
            return new APIResponse(400, "Unsuccessful!");
        }
    }

    @Override
    public APIResponse checkAccessToken(String username, String accessToken, String refreshToken) {
        User dbUser = userRepository.findByUsername(username);

        if (dbUser == null) {
            return new APIResponse(400, "Username or Password is Wrong!");
        } else {
            // Check Token
            HttpEntity httpEntity = new HttpEntity<>(setHeaders());

            restTemplate.setErrorHandler(restTemplateResponseErrorHandler);

            ResponseEntity<Object> responseEntity = restTemplate.exchange(
                    URLConfiguration.CHECK_ACCESS_TOKEN + accessToken, HttpMethod.GET, httpEntity, Object.class);

            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                return new APIResponse(200, "Continue!");
            } else {
                return refreshAccessToken(refreshToken);
            }
        }
    }


    private HttpHeaders setHeaders() {
        String clientCredentials = clientID + ":" + clientSecret;
        String authBasicHeaderClient = "Basic " + Base64.getEncoder().encodeToString(clientCredentials.getBytes());

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.AUTHORIZATION, authBasicHeaderClient);
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        return httpHeaders;
    }
}