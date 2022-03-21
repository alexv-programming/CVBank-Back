package cvBank.back.employee.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import cvBank.back.employee.model.EmployeeAccount;

public interface EmployeeAccountingRepository extends MongoRepository<EmployeeAccount, String> {

}
