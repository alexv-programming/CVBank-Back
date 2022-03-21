package cvBank.back.cvService.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import cvBank.back.cvService.model.CvEntity;

public interface CvRepository extends MongoRepository<CvEntity,String> {

}
