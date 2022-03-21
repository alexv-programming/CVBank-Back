package cvBank.back.employer.dto;

import java.util.List;
import java.util.Map;

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
public class ResponseEmployerLogRegDto {
	String email;
	ApplicantInfoDto applicantInfo;
	CompanyInfoDto companyInfo;
	Map<String, List<String>> cvCollections; 
}
