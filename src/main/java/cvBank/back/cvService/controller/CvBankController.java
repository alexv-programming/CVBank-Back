package cvBank.back.cvService.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cvBank.back.cvService.dto.AddCvDto;
import cvBank.back.cvService.dto.AddUpdateCvResponseDto;
import cvBank.back.cvService.dto.UpdateCvDto;
import cvBank.back.cvService.service.CvService;

@RestController
@RequestMapping("/cvbank/cv")
public class CvBankController {

	CvService cvService;

	public CvBankController(CvService cvService) {
		this.cvService = cvService;
	}

	@PostMapping
	public AddUpdateCvResponseDto addCv(@RequestBody AddCvDto newCv) {
		return cvService.addNewCv(newCv);
	}
	
	@PutMapping("/{cvId}")
	public AddUpdateCvResponseDto updateCv(@RequestBody UpdateCvDto cvToUpd, @PathVariable String cvId) {
		return cvService.updateCv(cvToUpd, cvId);
	}
}
