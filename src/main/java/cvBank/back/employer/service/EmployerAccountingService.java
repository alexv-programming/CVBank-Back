package cvBank.back.employer.service;

import cvBank.back.employer.dto.ResponseEmployerCVsDto;
import cvBank.back.employer.dto.RegisterEmployerDto;
import cvBank.back.employer.dto.ResponseEmployerLogRegDto;
import cvBank.back.employer.dto.EmployerDataDto;

public interface EmployerAccountingService {
	ResponseEmployerLogRegDto registerEmployer(RegisterEmployerDto registerEmployerDto);
	
	ResponseEmployerLogRegDto loginEmployer(String employerId);
	
	ResponseEmployerLogRegDto updateEmployer(String employerId, EmployerDataDto updateEmployerDto);
	
	ResponseEmployerCVsDto addCVCollection(String employerId, String collectionName);
	
	ResponseEmployerCVsDto addCVtoCollection(String employerId, String collectionName, String cvid);
	
	void deleteEmployer(String employerId);
	
	EmployerDataDto findEmployer(String companyName);
}
