package cvBank.back.employer.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@EqualsAndHashCode(of = {"email"})
public class EmployerAccount {
	@Id
	@Setter
	String email;
	@Setter
	ApplicantInfo applicantInfo;
	@Setter
	CompanyInfo companyInfo;
	@Setter
	String password;
	@Builder.Default //TODO check if needed or ask Edd
	Map<String, Set<String>> cvCollections = new HashMap<String, Set<String>>();
	//20211212 2:40 if map will not be made you will not be able to make it. constructor does not work in ModelMapper
	
	
	public boolean addCollection(String collectionName) {
		return cvCollections.put(collectionName, new HashSet<String>()) == null;
	}
	
	public boolean addCVtoCollection(String collectionName, String cv_id) {
		return cvCollections.get(collectionName).add(cv_id);
	}
}


