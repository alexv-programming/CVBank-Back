package cvBank.back.cvService.dto;

import java.util.List;

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
	List<Experience> experiences;
	List<Other> other;
	List<String> links;
	int template;

}
