package cvBank.back.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ResponseRegLoginDtoEmployee {
	
	String email;
	String firstName;
	String lastName;
	String[] cv_id; 

}
