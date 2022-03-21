package cvBank.back.cvService.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cvBank.back.cvService.dto.AddCvDto;
import cvBank.back.cvService.dto.AddUpdateCvResponseDto;
import cvBank.back.cvService.service.CvService;

@RestController
@RequestMapping("/cvbank/cv")
public class CvBankController {

	CvService cvService;

	public CvBankController(CvService cvService) {
		this.cvService = cvService;
	}

	@PostMapping
	public AddUpdateCvResponseDto addCv(AddCvDto newCv) {
		return cvService.addNewCv(newCv);
	}
}
