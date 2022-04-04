package cvBank.back.cvService.service;

import java.util.Set;

import cvBank.back.cvService.dto.AddCvDto;
import cvBank.back.cvService.dto.AddUpdateCvResponseDto;
import cvBank.back.cvService.dto.AggregationDto;
import cvBank.back.cvService.dto.UpdateCvDto;

public interface CvService {
	
	public AddUpdateCvResponseDto addNewCv(AddCvDto newCv);
	
	public AddUpdateCvResponseDto updateCv(UpdateCvDto cv, String cvId);
	
	public void removeCv(String cvId);

	public AddUpdateCvResponseDto anonymizeCv(String cvId, Set<String> fieldsToAnonymize);

	public Set<AddUpdateCvResponseDto> findCvsBySkills(Set<String> skills);

	public Set<AddUpdateCvResponseDto> findCvsByReadyToRelocate(String countryToRelocate);

	public Set<AddUpdateCvResponseDto> findCvsByVerified(String level);

	public Set<AddUpdateCvResponseDto> findCvsByLocation(String place, Integer distance);

	public Set<AddUpdateCvResponseDto> findCvsBySalary(Integer minSalary, Integer maxSalary);

	public Set<AddUpdateCvResponseDto> findCvsByPosition(String position);

	public AddUpdateCvResponseDto findCvById(String cvId);

	public Set<AddUpdateCvResponseDto> findCvsByIds(Set<String> cvIds);

	public Set<AddUpdateCvResponseDto> findCvsByAggregation(AggregationDto aggregationDto);
}
