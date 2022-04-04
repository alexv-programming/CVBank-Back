package cvBank.back.cvService.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cvBank.back.cvService.dao.CvRepository;
import cvBank.back.cvService.dto.AddCvDto;
import cvBank.back.cvService.dto.AddUpdateCvResponseDto;
import cvBank.back.cvService.dto.UpdateCvDto;
import cvBank.back.cvService.exceptions.NoSuchCvException;
import cvBank.back.cvService.model.CvEntity;
import cvBank.back.cvService.model.Experience;
import cvBank.back.cvService.model.Other;

@Service
public class CvServiceImpl implements CvService {

	ModelMapper modelMapper;
	CvRepository cvRepo;

	@Autowired
	public CvServiceImpl(ModelMapper modelMapper, CvRepository cvRepo) {
		this.modelMapper = modelMapper;
		this.cvRepo = cvRepo;
	}

	@Override
	public AddUpdateCvResponseDto addNewCv(AddCvDto newCv) {
		System.out.println("addNewCv");
		CvEntity cv = modelMapper.map(newCv, CvEntity.class);
		cvRepo.save(cv);
		return modelMapper.map(cv, AddUpdateCvResponseDto.class);
	}

	@Override
	public AddUpdateCvResponseDto updateCv(UpdateCvDto cv, String cvId) {
		CvEntity cvToUpdate = cvRepo.findById(cvId).orElseThrow(() -> new NoSuchCvException(cvId));
		cvToUpdate.setEmail(cv.getEmail());
		cvToUpdate.setPhone(cv.getPhone());
		cvToUpdate.setVerificationLevel(cv.getVerificationLevel());
		cvToUpdate.setPreambule(cv.getPreambule());
		
		Set<Experience> experience = cv.getExperience().stream().map(e -> modelMapper.map(e, Experience.class)).collect(Collectors.toSet());
		cvToUpdate.setExperience(experience);
		
		Other other = modelMapper.map(cv.getOther(), Other.class);
		cvToUpdate.setOther(other);
		cvToUpdate.setLinks(cv.getLinks());
		cvToUpdate.setTemplate(cv.getTemplate());
		cvRepo.save(cvToUpdate);
		return modelMapper.map(cvToUpdate, AddUpdateCvResponseDto.class);
	}

	@Override
	public void removeCv(String cvId) {
		CvEntity cv = cvRepo.findById(cvId).orElseThrow(() -> new NoSuchCvException(cvId));
		cvRepo.delete(cv);
		
	}

	@Override
	public AddUpdateCvResponseDto anonymizeCv(String cvId, Set<String> fieldsToAnonymize) throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException {
		CvEntity cv = cvRepo.findById(cvId).orElseThrow(() -> new NoSuchCvException(cvId));
		cv.setFieldsToAnonymize(fieldsToAnonymize);
		cvRepo.save(cv);
		cv.getAnonymizedCv(fieldsToAnonymize);
		return modelMapper.map(cv, AddUpdateCvResponseDto.class);
	}

	

}
