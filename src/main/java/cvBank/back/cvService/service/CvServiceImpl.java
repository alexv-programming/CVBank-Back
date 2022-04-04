package cvBank.back.cvService.service;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import cvBank.back.cvService.dao.CvRepository;
import cvBank.back.cvService.dto.AddCvDto;
import cvBank.back.cvService.dto.AddUpdateCvResponseDto;
import cvBank.back.cvService.dto.AggregationDto;
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
		return null;
	}

	@Override
	public void removeCv(String cvId) {
		CvEntity cv = cvRepo.findById(cvId).orElseThrow(() -> new NoSuchCvException(cvId));
		cvRepo.delete(cv);
	}

	@Override
	public AddUpdateCvResponseDto anonymizeCv(String cvId, Set<String> fieldsToAnonymize) {
		CvEntity cvToAnonymize = cvRepo.findById(cvId).orElseThrow(() -> new NoSuchCvException(cvId));
//		Query query = new Query();
//		query.fields().include(cvToAnonymize)
		cvToAnonymize.setAnanimizedFields(fieldsToAnonymize);
		cvRepo.save(cvToAnonymize);
//		CvEntity cvRes;
		try {
			cvToAnonymize.getWithoutAnanimizedFields();
			return modelMapper.map(cvToAnonymize, AddUpdateCvResponseDto.class);
		} catch ( SecurityException | IllegalArgumentException  e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Set<AddUpdateCvResponseDto> findCvsBySkills(Set<String> skills) {
//		Set<CvEntity> res= new HashSet<>();
//		for (Iterator<String> iterator = skills.iterator(); iterator.hasNext();) {
//			String skill = (String) iterator.next();
//			res.addAll(cvRepo.findBySkills(skill).collect(Collectors.toSet()));
//		}
//		return res.stream()
		return cvRepo.findBySkillsIn(skills)
				.map(cv -> modelMapper.map(cv, AddUpdateCvResponseDto.class))
				.collect(Collectors.toSet());
	}

	@Override
	public Set<AddUpdateCvResponseDto> findCvsByReadyToRelocate(String countryToRelocate) {
		return cvRepo.findByIsRelocated(countryToRelocate)
				.map(cv -> modelMapper.map(cv, AddUpdateCvResponseDto.class))
				.collect(Collectors.toSet());
	}

	@Override
	public Set<AddUpdateCvResponseDto> findCvsByVerified(String level) {
		return cvRepo.findByVerificationLevel(level)
				.map(cv -> modelMapper.map(cv, AddUpdateCvResponseDto.class))
				.collect(Collectors.toSet());
	}

	@Override
	public Set<AddUpdateCvResponseDto> findCvsByLocation(String place, Integer distance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<AddUpdateCvResponseDto> findCvsBySalary(Integer minSalary, Integer maxSalary) {
		return cvRepo.findBySalaryBetween(minSalary, maxSalary)
				.map(cv -> modelMapper.map(cv, AddUpdateCvResponseDto.class))
				.collect(Collectors.toSet());
	}

	@Override
	public Set<AddUpdateCvResponseDto> findCvsByPosition(String position) {
		return cvRepo.findByPosition(position)
				.map(cv -> modelMapper.map(cv, AddUpdateCvResponseDto.class))
				.collect(Collectors.toSet());
	}

	@Override
	public AddUpdateCvResponseDto findCvById(String cvId) {
		CvEntity cvEntity = cvRepo.findById(cvId).orElseThrow(() -> new NoSuchCvException(cvId));
		//cvEntity.getWithoutAnanimizedFields();
		return modelMapper.map(cvEntity, AddUpdateCvResponseDto.class);
	}

	@Override
	public Set<AddUpdateCvResponseDto> findCvsByIds(Set<String> cvIds) {
		return ((Collection<CvEntity>) cvRepo.findAllById(cvIds)).stream()
				.map(cv -> modelMapper.map(cv, AddUpdateCvResponseDto.class))
				.collect(Collectors.toSet());
	}

	@Override
	public Set<AddUpdateCvResponseDto> findCvsByAggregation(AggregationDto aggregationDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
