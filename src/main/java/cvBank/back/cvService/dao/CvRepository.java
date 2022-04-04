package cvBank.back.cvService.dao;

import java.util.Set;
import java.util.stream.Stream;

import org.springframework.data.mongodb.repository.MongoRepository;

import cvBank.back.cvService.model.CvEntity;

public interface CvRepository extends MongoRepository<CvEntity,String> {
	
	Stream<CvEntity> findBySkillsIn(Set<String> skills);
	
	Stream<CvEntity> findByIsRelocated(String isRelocated);

	Stream<CvEntity> findByVerificationLevel(String verificationLevel);
	
	Stream<CvEntity> findBySalaryBetween(Integer minSalary, Integer maxSalary);
	
	Stream<CvEntity> findByPosition(String position);
	
	
}
