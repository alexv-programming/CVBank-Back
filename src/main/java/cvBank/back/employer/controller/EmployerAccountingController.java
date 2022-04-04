 package cvBank.back.employer.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

@Controller
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
	public ResponseEmployerLogRegDto loginEmployer(@RequestHeader("Authorization") String login) {
		return service.loginEmployer(login);
	}
	
	@PutMapping("/{employerId}")
	public ResponseEmployerLogRegDto updateEmployer(@PathVariable String employerId, @RequestBody EmployerDataDto updateEmployerDto) {
		return service.updateEmployer(employerId, updateEmployerDto);
	}
	
	@PutMapping("/{employerId}/collection/{collectionName}")
	public ResponseEmployerCVsDto addCVCollection(@PathVariable String employerId, @PathVariable String collectionName) {
		return service.addCVCollection(employerId, collectionName);
	}

	@PutMapping("/{employerId}/collection/{collectionName}/{cvid}")
	ResponseEmployerCVsDto addCVtoCollection(@PathVariable String employerId, @PathVariable String collectionName, @PathVariable String cvid) {
		return service.addCVtoCollection(employerId, collectionName, cvid);
	}
	
	@DeleteMapping("/{employerId}")
	public void deleteEmployer(@PathVariable String employerId) {
		service.deleteEmployer(employerId);
	}
	
	@GetMapping("/company/{companyName}")
	public List<EmployerDataDto> findEmployer(@PathVariable String companyName)  {
		return service.findEmployer(companyName);
	}
	
	@PutMapping("/login")
	public ResponseEmployerLogRegDto changeLogin(@RequestHeader String authorization, @RequestHeader("X-Login") String newLogin) {
		return service.changeLogin(authorization, newLogin);
	}
	
	@PutMapping("/pass")
	public void ChangePassword(@RequestHeader String authorization, @RequestHeader("Old-Pass") String oldPassword, @RequestHeader("X-Password") String newPassword) {
		service.changePassword(authorization, oldPassword, newPassword);
	}
}
