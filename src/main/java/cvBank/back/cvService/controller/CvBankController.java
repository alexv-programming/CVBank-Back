package cvBank.back.cvService.controller;

import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cvBank.back.cvService.dto.AddCvDto;
import cvBank.back.cvService.dto.AddUpdateCvResponseDto;
import cvBank.back.cvService.dto.AggregationDto;
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
	
	@PutMapping("/anonymizer/{cvId}")
	public AddUpdateCvResponseDto anonymizeCv(@PathVariable String cvId, @RequestBody Set<String> fieldsToAnonymize) {
		return cvService.anonymizeCv(cvId, fieldsToAnonymize);
	}
	
	@GetMapping("/cvs/skills")
	public Set<AddUpdateCvResponseDto> findCvsBySkills(@RequestBody Set<String> skills) {
		return cvService.findCvsBySkills(skills);
	}
	
	@GetMapping("/cvs/relocated/{countryToRelocate}")
	public Set<AddUpdateCvResponseDto> findCvsByReadyToRelocate(@PathVariable String countryToRelocate) {
		return cvService.findCvsByReadyToRelocate(countryToRelocate);
	}
	
	@GetMapping("/cvs/verified/{level}")
	public Set<AddUpdateCvResponseDto> findCvsByVerified(@PathVariable String level) {
		return cvService.findCvsByVerified(level);
	}
	
	@GetMapping("/cvs/location/{place}/{distance}")
	public Set<AddUpdateCvResponseDto> findCvsByLocation(@PathVariable String place, @PathVariable Integer distance) {
		return cvService.findCvsByLocation(place, distance);
	}
	
	@GetMapping("/cvs/salary/{minSalary}/{maxSalary}")
	public Set<AddUpdateCvResponseDto> findCvsBySalary(@PathVariable Integer minSalary, @PathVariable Integer maxSalary) {
		return cvService.findCvsBySalary(minSalary, maxSalary);
	}
	
	@GetMapping("/cvs/position/{position}")
	public Set<AddUpdateCvResponseDto> findCvsByPosition(@PathVariable String position) {
		return cvService.findCvsByPosition(position);
	}
	
	@GetMapping("/{cvId}")
	public AddUpdateCvResponseDto findCvById(@PathVariable String cvId) {
		return cvService.findCvById(cvId);
	}
	
	@GetMapping("/cvs")
	public Set<AddUpdateCvResponseDto> findCvsByIds(@RequestBody Set<String> cvIds) {
		return cvService.findCvsByIds(cvIds);
	}
	
	@GetMapping("/cvs/aggregate")
	public Set<AddUpdateCvResponseDto> findCvsByAggregation(@RequestBody AggregationDto aggregationDto) {
		return cvService.findCvsByAggregation(aggregationDto);
    
	}
	@DeleteMapping("/{cvId}")
	public void deleteCv(@PathVariable String cvId) {
		cvService.removeCv(cvId);
	}
	
	}
