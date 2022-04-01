package cvBank.back.cvService.model;

import java.util.List;
import java.util.Set;

import cvBank.back.cvService.dto.ProjectDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Experience {
String date;
String company;
String website;
String address;
List<ProjectDto> projects;
}
