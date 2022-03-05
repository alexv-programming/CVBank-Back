package cvBank.back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cvBank.back.employer.dao.EmployerAccountingMongoRepository;

@SpringBootApplication
public class CvBankBackendApplication {
	
	EmployerAccountingMongoRepository employerRepository;
	
	@Autowired
	public CvBankBackendApplication(EmployerAccountingMongoRepository employerRepository) {
		this.employerRepository = employerRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(CvBankBackendApplication.class, args);
	}

}
