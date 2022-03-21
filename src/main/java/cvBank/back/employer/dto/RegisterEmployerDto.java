package cvBank.back.employer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RegisterEmployerDto {
	String email;
	ApplicantInfoDto applicantInfo;
	CompanyInfoDto companyInfo;
	String password;
}
