package cvBank.back.cvService.dto;

import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class UpdateCvDto {
	
	String email;
	String phone;
	int verificationLevel;
	String preambule;
	Set<ExperienceDto> experience;
	OtherDto other;
	List<String> links;
	int template;

}
