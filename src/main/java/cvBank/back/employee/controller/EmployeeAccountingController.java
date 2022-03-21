package cvBank.back.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cvBank.back.employee.dto.RegisterEmployeeDto;
import cvBank.back.employee.dto.ResponseRegLoginDtoEmployee;
import cvBank.back.employee.dto.UpdateEmployeeDto;
import cvBank.back.employee.service.EmployeeAccountingService;

@RestController
@RequestMapping("/cvbank/employee")
public class EmployeeAccountingController {
	
	EmployeeAccountingService service;
	
	@Autowired
	public EmployeeAccountingController(EmployeeAccountingService service) {
		this.service = service;
	}
	@PostMapping("/register")
	public ResponseRegLoginDtoEmployee registerUser(@RequestBody RegisterEmployeeDto registerNewEmployee) {
		return service.registerNewEmployee(registerNewEmployee);
	}
	@PostMapping("/login")
	public ResponseRegLoginDtoEmployee login(@RequestHeader("Authorization") String login) {
		return service.loginEmployee(login);
	}
	
	@DeleteMapping("/{employeeId}")
	public void deleteEmployee(@PathVariable String employeeId) {
		service.deleteEmployee(employeeId);
	}
	
	@PutMapping("/{employeeId}")
	public UpdateEmployeeDto updateEmployeeData(@PathVariable String employeeId, @RequestBody UpdateEmployeeDto updatedInfo) {
		return service.updateEmployeeData(updatedInfo, employeeId);
	}
	
	@GetMapping("/{employeeId}")
	public ResponseRegLoginDtoEmployee findEmployeeById(@PathVariable String employeeId) {
		return service.findEmployeebyId(employeeId);
	}
	
	
	

}
