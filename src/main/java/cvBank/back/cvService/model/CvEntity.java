package cvBank.back.cvService.model;

import java.lang.reflect.Field;
import java.util.Iterator;
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
	Set<String> ananimizedFields;
	
	public void getWithoutAnanimizedFields() {
		if (ananimizedFields == null || ananimizedFields.size() == 0) {
			return;
		}
		for (String string : ananimizedFields) {
			
			try {
				Field field = CvEntity.class.getDeclaredField(string);
				//field.setAccessible(true);
				field.set(this, null);
			} catch (NoSuchFieldException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
}
