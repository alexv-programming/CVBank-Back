package cvBank.back.employee.model;

import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode(of = { "email" })
public class EmployeeAccountModel {
	@Id
	String email;
	String firstName;
	String lastName;
	String password;
	Map<String, List<String>> employeeCV;
	
	
	// public boolean addCv()

}
