package cvBank.back.employee.model;

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
	List<String> employeesCV;
	
	
	public boolean addCv(String cv) {
		return employeesCV.add(cv);
	}

	public boolean removeCv(String cv) {
		return employeesCV.remove(cv);
	}
}
