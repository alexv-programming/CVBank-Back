package cvBank.back.cvService.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cvBank.back.cvService.dao.CvRepository;
import cvBank.back.cvService.dto.AddCvDto;
import cvBank.back.cvService.dto.AddUpdateCvResponseDto;
import cvBank.back.cvService.model.CvEntity;

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
		CvEntity cv = modelMapper.map(newCv, CvEntity.class);
		cvRepo.save(cv);
		return modelMapper.map(cv, AddUpdateCvResponseDto.class);
	}

}
