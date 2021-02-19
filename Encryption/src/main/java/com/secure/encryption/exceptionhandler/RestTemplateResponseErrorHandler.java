package com.secure.encryption.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

@Component
public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {
    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        /*return (response.getStatusCode().series() == CLIENT_ERROR || response.getStatusCode().series() == SERVER_ERROR);*/
        return response.getStatusCode() != HttpStatus.OK;
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        if (response.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR) {
            // handle SERVER_ERROR
        } else if (response.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR) {
            // handle CLIENT_ERROR
            if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
                // handle NOT_FOUND_ERROR
            }
        } else if (response.getStatusCode().is4xxClientError() || response.getStatusCode().is5xxServerError()){
            System.err.println("Error: " + response.getStatusCode() + " " + response.getStatusText());
        }
    }
}
