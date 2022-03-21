package cvBank.back.employer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ApplicantInfo {
//	String email;
	String firstName;
    String lastName;
    String position;
    String phone;
}
