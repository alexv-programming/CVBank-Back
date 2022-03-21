package cvBank.back.cvService.service;

import cvBank.back.cvService.dto.AddCvDto;
import cvBank.back.cvService.dto.AddUpdateCvResponseDto;

public interface CvService {
	
	public AddUpdateCvResponseDto addNewCv(AddCvDto newCv);
	

}
