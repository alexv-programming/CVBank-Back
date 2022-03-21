package cvBank.back.employee.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cvBank.back.employee.dao.EmployeeAccountingRepository;
import cvBank.back.employee.dto.RegisterEmployeeDto;
import cvBank.back.employee.dto.ResponseRegLoginDtoEmployee;
import cvBank.back.employee.dto.UpdateEmployeeDto;
import cvBank.back.employee.exceptions.EmployeeExistsException;
import cvBank.back.employee.exceptions.EmployeeNotFoundException;

import cvBank.back.employee.model.EmployeeAccount;


@Service
public class EmployeeAccountingServiceImpl implements EmployeeAccountingService {
	EmployeeAccountingRepository repository;
	ModelMapper modelMapper;

	@Autowired
	public EmployeeAccountingServiceImpl(EmployeeAccountingRepository repository, ModelMapper modelMapper) {
		this.repository = repository;
		this.modelMapper = modelMapper;
	}

	@Override
	public ResponseRegLoginDtoEmployee registerNewEmployee(RegisterEmployeeDto registerEmployeeDto) {
		if(repository.existsById(registerEmployeeDto.getEmail())) {
			throw new EmployeeExistsException(registerEmployeeDto.getEmail());
		}
		EmployeeAccount employeeAccount = modelMapper.map(registerEmployeeDto, EmployeeAccount.class);
		repository.save(employeeAccount);
		return modelMapper.map(employeeAccount, ResponseRegLoginDtoEmployee.class);
	}

	@Override
	public ResponseRegLoginDtoEmployee loginEmployee(String email) {
		EmployeeAccount employeeAccount = repository.findById(email)
				.orElseThrow(() -> new EmployeeNotFoundException(email));
		return modelMapper.map(employeeAccount, ResponseRegLoginDtoEmployee.class);
	}

	@Override
	public UpdateEmployeeDto updateEmployeeData(UpdateEmployeeDto updatedInfo, String employeeId) {
		EmployeeAccount employeeAccount = repository.findById(employeeId)
				.orElseThrow(() -> new EmployeeNotFoundException(employeeId));
		if(updatedInfo.getFirstName() != null) {
			employeeAccount.setFirstName(updatedInfo.getFirstName());
		}
		if(updatedInfo.getLastName() != null) {
			employeeAccount.setLastName(updatedInfo.getLastName());
		}
		repository.save(employeeAccount);
		return modelMapper.map(employeeAccount, UpdateEmployeeDto.class); 
	}

	@Override
	public void deleteEmployee(String employeeId) {
		EmployeeAccount employeeAccount = repository.findById(employeeId)
				.orElseThrow(() -> new EmployeeNotFoundException(employeeId));
		repository.delete(employeeAccount);

	}

	@Override
	public ResponseRegLoginDtoEmployee findEmployeebyId(String employeeId) {
		EmployeeAccount employeeAccount = repository.findById(employeeId)
				.orElseThrow(() -> new EmployeeNotFoundException(employeeId));
		return modelMapper.map(employeeAccount, ResponseRegLoginDtoEmployee.class);
	}
}
