package cvBank.back.employer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cvBank.back.employer.dto.EmployerDataDto;
import cvBank.back.employer.dto.RegisterEmployerDto;
import cvBank.back.employer.dto.ResponseEmployerCVsDto;
import cvBank.back.employer.dto.ResponseEmployerLogRegDto;
import cvBank.back.employer.service.EmployerAccountingService;

@RestController
@RequestMapping("/cvbank/employer")
public class EmployerAccountingController {
	EmployerAccountingService service;

	@Autowired
	public EmployerAccountingController(EmployerAccountingService service) {
		this.service = service;
	}
	
	@PostMapping("/register")
	public ResponseEmployerLogRegDto registerEmployer(@RequestBody RegisterEmployerDto registerEmployerDto) {
		return service.registerEmployer(registerEmployerDto);
	}
	
	@PostMapping("/login")
	ResponseEmployerLogRegDto loginEmployer( String employerId) {
		return service.loginEmployer(employerId);
	}
	
	@PutMapping("/{employerId}")
	ResponseEmployerLogRegDto updateEmployer(String employerId, EmployerDataDto updateEmployerDto) {
		return service.updateEmployer(employerId, updateEmployerDto);
	}
	
	@PutMapping("/{employerId}/collection/{collectionName}")
	ResponseEmployerCVsDto addCVCollection(String employerId, String collectionName) {
		return service.addCVCollection(employerId, collectionName);
	}

	@PutMapping("/{employerId}/collection/{collectionName}/{cvid}")
	ResponseEmployerCVsDto addCVtoCollection(String employerId, String collectionName, String cvid) {
		return service.addCVtoCollection(employerId, collectionName, cvid);
	}
	
	@DeleteMapping("/{employerId}")
	void deleteEmployer(String employerId) {
		service.deleteEmployer(employerId);
	}
	
	@GetMapping("/{companyName}")
	EmployerDataDto findEmployer(String companyName)  {
		return service.findEmployer(companyName);
	}

}
