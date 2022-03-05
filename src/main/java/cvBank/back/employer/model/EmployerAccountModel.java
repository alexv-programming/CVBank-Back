package cvBank.back.employer.model;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class EmployerAccountModel {
	@Id
	String id;
	@Setter
	ApplicantInfo applicantInfo;
	@Setter
	CompanyInfo companyInfo;
	@Setter
	String password;
}
