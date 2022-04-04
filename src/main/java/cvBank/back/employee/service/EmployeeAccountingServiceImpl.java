package cvBank.back.employee.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cvBank.back.employee.dao.EmployeeAccountingRepository;
import cvBank.back.employee.dto.RegisterEmployeeDto;
import cvBank.back.employee.dto.ResponseRegLoginDtoEmployee;
import cvBank.back.employee.dto.UpdateEmployeeDto;
import cvBank.back.employee.exceptions.AccountWithThisLoginAlreadyExistsException;
import cvBank.back.employee.exceptions.EmployeeExistsException;
import cvBank.back.employee.exceptions.EmployeeNotFoundException;

import cvBank.back.employee.model.EmployeeAccount;
import cvBank.back.employer.dto.exceptions.TheSamePasswordException;
import cvBank.back.employer.dto.exceptions.WrongPasswordException;

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
		if (repository.existsById(registerEmployeeDto.getEmail())) {
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
		if (updatedInfo.getFirstName() != null) {
			employeeAccount.setFirstName(updatedInfo.getFirstName());
		}
		if (updatedInfo.getLastName() != null) {
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

	@Override
	public ResponseRegLoginDtoEmployee changeLogin(String newLogin, String login) {
		EmployeeAccount employeeAccount = repository.findById(login)
				.orElseThrow(() -> new EmployeeNotFoundException(login));
		if (repository.existsById(newLogin)) {
			throw new AccountWithThisLoginAlreadyExistsException(newLogin);
		}
		employeeAccount.setEmail(newLogin);
		repository.save(employeeAccount);
		repository.deleteById(login);
		return modelMapper.map(employeeAccount, ResponseRegLoginDtoEmployee.class);
	}

	@Override
	public void changePassword(String login, String oldPassword, String newPassword) {
		EmployeeAccount employeeAccount = repository.findById(login)
				.orElseThrow(() -> new EmployeeNotFoundException(login));

		if (!employeeAccount.getPassword().equals(oldPassword)) {
			throw new WrongPasswordException();
		}
		if (newPassword.equals(oldPassword)) {
			throw new TheSamePasswordException();
		}
		employeeAccount.setPassword(newPassword);
		repository.save(employeeAccount);

	}

	@Override
	public ResponseRegLoginDtoEmployee addCv(String employeeId, String cvId) {
		EmployeeAccount employeeAccount = repository.findById(employeeId)
				.orElseThrow(() -> new EmployeeNotFoundException(employeeId));
		employeeAccount.addCv(cvId);
		repository.save(employeeAccount);
		return modelMapper.map(employeeAccount, ResponseRegLoginDtoEmployee.class);
	}

	@Override
	public ResponseRegLoginDtoEmployee removeCv(String employeeId, String cvId) {
		EmployeeAccount employeeAccount = repository.findById(employeeId)
				.orElseThrow(() -> new EmployeeNotFoundException(employeeId));
		employeeAccount.removeCv(cvId);
		repository.save(employeeAccount);
		return modelMapper.map(employeeAccount, ResponseRegLoginDtoEmployee.class);
	}
}
