package cvBank.back.employee.model;

import java.util.ArrayList;
import java.util.List;


import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of = { "email" })
public class EmployeeAccount {
	@Id
	String email;
	String firstName;
	String lastName;
	String password; 
	List<String> cv_id = new ArrayList<String>();
	
	
	public boolean addCv(String cv) {
		return cv_id.add(cv);
	}

	public boolean removeCv(String cv) {
		return cv_id.remove(cv);
	}
}
