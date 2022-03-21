package cvBank.back.cvService.dto;

import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class AddUpdateCvResponseDto {
	
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
