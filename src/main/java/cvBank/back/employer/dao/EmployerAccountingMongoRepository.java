package cvBank.back.employer.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import cvBank.back.employer.model.EmployerAccount;

public interface EmployerAccountingMongoRepository extends MongoRepository<EmployerAccount, String> {
	
	List<EmployerAccount> findByCompanyInfoName(String companyName);

}
