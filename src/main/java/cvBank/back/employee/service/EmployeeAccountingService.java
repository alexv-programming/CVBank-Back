package cvBank.back.employee.service;

import cvBank.back.employee.dto.RegisterEmployeeDto;
import cvBank.back.employee.dto.ResponseRegLoginDtoEmployee;
import cvBank.back.employee.dto.UpdateEmployeeDto;

public interface EmployeeAccountingService {

	ResponseRegLoginDtoEmployee registerNewEmployee(RegisterEmployeeDto registerEmployeeDto);
	
	ResponseRegLoginDtoEmployee loginEmployee(String email);
	
	UpdateEmployeeDto updateEmployeeData(UpdateEmployeeDto updatedInfo, String employeeId);
	
	void deleteEmployee(String employeeId);
	
	ResponseRegLoginDtoEmployee findEmployeebyId(String employeeId);
	
	
}
