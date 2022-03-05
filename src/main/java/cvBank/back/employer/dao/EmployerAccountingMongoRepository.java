package cvBank.back.employer.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import cvBank.back.employer.model.EmployerAccountModel;

public interface EmployerAccountingMongoRepository extends MongoRepository<EmployerAccountModel, String> {

}
