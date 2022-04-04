package cvBank.back.cvService.service;

import java.util.Set;

import cvBank.back.cvService.dto.AddCvDto;
import cvBank.back.cvService.dto.AddUpdateCvResponseDto;
import cvBank.back.cvService.dto.UpdateCvDto;

public interface CvService {
	
	public AddUpdateCvResponseDto addNewCv(AddCvDto newCv);
	
	public AddUpdateCvResponseDto updateCv(UpdateCvDto cv, String cvId);
	
	public void removeCv(String cvId);
	
	public AddUpdateCvResponseDto anonymizeCv(String cvId, Set<String> fieldsToAnonymize) throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException;
	

}
