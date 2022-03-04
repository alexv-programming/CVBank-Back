package cvBank.back.employer.dto;

import java.util.List;
import java.util.Map;


public class ResponseEmployerLogRegDTO {
	ApplicantInfoDTO applicantInfo;
	CompanyInfoDTO companyInfo;
	Map<String, List<String>> cvCollections; 
}
