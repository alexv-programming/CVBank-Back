package cvBank.back.cvService.model;

import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.Id;

import cvBank.back.cvService.dto.Education;
import cvBank.back.cvService.dto.Experience;
import cvBank.back.cvService.dto.Other;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})

public class CvEntity {
	@Id
	String id;
	String firstName;
	String lastName;
	String email;
	String phone;
	int verificationLevel;
	boolean isRelevant;
	String isRelocated;
	int salary;
	String address;
	String position;
	String preambule;
	Set<String> skills;
	List<Experience> experiences;
	List<Education> education;
	List<Other> other;
	List<String> links;

}
