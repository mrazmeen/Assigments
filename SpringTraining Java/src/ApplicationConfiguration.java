

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.razmeen.training.salesmanager.repository.EmployeeRepository;
import com.razmeen.training.salesmanager.repository.HibernateEmployeeRepositoryImpl;
import com.razmeen.training.salesmanager.service.EmployeeService;
import com.razmeen.training.salesmanager.service.EmployeeServiceImpl;

@Configuration
public class ApplicationConfiguration {
	
	@Bean(name="employeeService")
	public EmployeeService getEmployeeService() {
		
		EmployeeServiceImpl employeeService= new EmployeeServiceImpl();
		employeeService.setEmployeerepository(getEmployeeRepository());
		return  employeeService;
	}
	
	@Bean(name="employeerepository")
	public EmployeeRepository getEmployeeRepository() {
		return new HibernateEmployeeRepositoryImpl();
	}

}
