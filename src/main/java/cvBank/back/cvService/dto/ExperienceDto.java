package cvBank.back.cvService.dto;

import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ExperienceDto {
String date;
String company;
String website;
String address;
List<ProjectDto> projects;
}
