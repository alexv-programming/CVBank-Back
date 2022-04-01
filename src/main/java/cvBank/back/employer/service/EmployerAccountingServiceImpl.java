package cvBank.back.employer.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cvBank.back.employer.dao.EmployerAccountingMongoRepository;
import cvBank.back.employer.dto.EmployerDataDto;
import cvBank.back.employer.dto.RegisterEmployerDto;
import cvBank.back.employer.dto.ResponseEmployerCVsDto;
import cvBank.back.employer.dto.ResponseEmployerLogRegDto;
import cvBank.back.employer.dto.exceptions.EmployerExistsException;
import cvBank.back.employer.dto.exceptions.EmployerNotFoundException;
import cvBank.back.employer.dto.exceptions.TheSamePasswordException;
import cvBank.back.employer.dto.exceptions.WrongPasswordException;
import cvBank.back.employer.model.ApplicantInfo;
import cvBank.back.employer.model.CompanyInfo;
import cvBank.back.employer.model.EmployerAccount;

@Service
public class EmployerAccountingServiceImpl implements EmployerAccountingService {

	EmployerAccountingMongoRepository repository;
	ModelMapper modelMapper;

	@Autowired
	public EmployerAccountingServiceImpl(EmployerAccountingMongoRepository repository, ModelMapper modelMapper) {
		this.repository = repository;
		this.modelMapper = modelMapper;
	}

	@Override
	public ResponseEmployerLogRegDto registerEmployer(RegisterEmployerDto registerEmployerDto) {
		String employerId = registerEmployerDto.getEmail();
		if (repository.existsById(employerId)) {
			throw new EmployerExistsException(employerId);
		}
		EmployerAccount employerAccount = repository.save(modelMapper.map(registerEmployerDto, EmployerAccount.class));
		return modelMapper.map(employerAccount, ResponseEmployerLogRegDto.class);
	}

	@Override
	public ResponseEmployerLogRegDto loginEmployer(String employerId) {
		EmployerAccount employerAccount = repository.findById(employerId)
				.orElseThrow(() -> new EmployerNotFoundException(employerId));
		return modelMapper.map(employerAccount, ResponseEmployerLogRegDto.class);
	}

	@Override
	public ResponseEmployerLogRegDto updateEmployer(String employerId, EmployerDataDto updateEmployerDto) {
		EmployerAccount employerAccount = repository.findById(employerId)
				.orElseThrow(() -> new EmployerNotFoundException(employerId));
		employerAccount.setApplicantInfo(modelMapper.map(updateEmployerDto.getApplicantInfo(), ApplicantInfo.class));
		employerAccount.setCompanyInfo(modelMapper.map(updateEmployerDto.getCompanyInfo(), CompanyInfo.class));
		repository.save(employerAccount);
		return modelMapper.map(employerAccount, ResponseEmployerLogRegDto.class);
	}

	@Override
	public ResponseEmployerCVsDto addCVCollection(String employerId, String collectionName) {
		EmployerAccount employerAccount = repository.findById(employerId)
				.orElseThrow(() -> new EmployerNotFoundException(employerId));
		employerAccount.addCollection(collectionName);
		repository.save(employerAccount);
		return modelMapper.map(employerAccount, ResponseEmployerCVsDto.class);
	}

	@Override
	public ResponseEmployerCVsDto addCVtoCollection(String employerId, String collectionName, String cvid) {
		EmployerAccount employerAccount = repository.findById(employerId)
				.orElseThrow(() -> new EmployerNotFoundException(employerId));
		employerAccount.addCVtoCollection(collectionName, cvid);
		repository.save(employerAccount);
		return modelMapper.map(employerAccount, ResponseEmployerCVsDto.class);
	}

	@Override
	public void deleteEmployer(String employerId) {
		EmployerAccount employerAccount = repository.findById(employerId)
				.orElseThrow(() -> new EmployerNotFoundException(employerId));
		repository.delete(employerAccount);
	}

	@Override
	public List<EmployerDataDto> findEmployer(String companyName) {
		List<EmployerAccount> list = repository.findByCompanyInfoName(companyName);
		if (list.size() == 0) {
			throw new EmployerNotFoundException();
		}
		return list.stream().map(ea -> modelMapper.map(ea, EmployerDataDto.class)).collect(Collectors.toList());
	}

	@Override
	public ResponseEmployerLogRegDto changeLogin(String employerId, String newLogin) {
		EmployerAccount employerAccount = repository.findById(employerId)
			.orElseThrow(() -> new EmployerNotFoundException(employerId));
		if (repository.existsById(newLogin)) {
			throw new EmployerExistsException(newLogin);
		}
		employerAccount.setEmail(newLogin);
		repository.save(employerAccount);
		repository.deleteById(employerId);
		return modelMapper.map(employerAccount, ResponseEmployerLogRegDto.class);
	}

	@Override
	public void changePassword(String authorization, String oldPassword, String newPassword) {
		EmployerAccount employerAccount = repository.findById(authorization)
				.orElseThrow(() -> new EmployerNotFoundException(authorization));
		if(!employerAccount.getPassword().equals(oldPassword)) {
			throw new WrongPasswordException();
		}
		if(newPassword.equals(oldPassword)) {
			throw new TheSamePasswordException();
		}
		employerAccount.setPassword(newPassword);
		repository.save(employerAccount);
	}

}
