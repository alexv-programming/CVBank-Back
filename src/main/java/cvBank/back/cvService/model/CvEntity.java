package cvBank.back.cvService.model;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = { "id" })

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
	Set<Experience> experience;
	Set<Education> educations;
	Other other;
	List<String> links;
	int template;
	Set<String> fieldsToAnonymize;

	public CvEntity getAnonymizedCv(Set<String> fieldsToAnonymize) throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException {
		// Class klazz = Class.forName("CvEntity");
		// fields.addAll(Arrays.asList(klazz.getDeclaredFields()));
		//Field[] fieldsToDisplay = findFieldsByNames(fieldsToAnonymize);
		
		Field[] fields = CvEntity.class.getDeclaredFields();
		for (Field f : fields) {
			for (String s : fieldsToAnonymize) {
				if (f.getName().equals(s)) {
					f.set(this, null);
				}
			}
		}
		return this;
	}

	

	
}
