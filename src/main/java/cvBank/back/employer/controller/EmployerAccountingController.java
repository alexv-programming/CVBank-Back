 package cvBank.back.employer.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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
	
	@PostMapping("/signup")
	public ResponseEmployerLogRegDto registerEmployer(@RequestBody RegisterEmployerDto registerEmployerDto) {
		return service.registerEmployer(registerEmployerDto);
	}
	
	@PostMapping("/signin")
	ResponseEmployerLogRegDto loginEmployer(@RequestHeader("Authorization2") String login) {
		return service.loginEmployer(login);
	}
	
	@PutMapping("/{employerId}")
	ResponseEmployerLogRegDto updateEmployer(@PathVariable String employerId, @RequestBody EmployerDataDto updateEmployerDto) {
		return service.updateEmployer(employerId, updateEmployerDto);
	}
	
	@PutMapping("/{employerId}/collection/{collectionName}")
	ResponseEmployerCVsDto addCVCollection(@PathVariable String employerId, @PathVariable String collectionName) {
		return service.addCVCollection(employerId, collectionName);
	}

	@PutMapping("/{employerId}/collection/{collectionName}/{cvid}")
	ResponseEmployerCVsDto addCVtoCollection(@PathVariable String employerId, @PathVariable String collectionName, @PathVariable String cvid) {
		return service.addCVtoCollection(employerId, collectionName, cvid);
	}
	
	@DeleteMapping("/{employerId}")
	void deleteEmployer(@PathVariable String employerId) {
		service.deleteEmployer(employerId);
	}
	
	@GetMapping("/company/{companyName}")
	List<EmployerDataDto> findEmployer(@PathVariable String companyName)  {
		return service.findEmployer(companyName);
	}
	
	@PutMapping("/login")
	ResponseEmployerLogRegDto changeLogin(@RequestHeader String authorization2, @RequestHeader("X-Login") String newLogin) {
		return service.changeLogin(authorization2, newLogin);
	}

}
