package software.hrms.entities.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import software.hrms.entities.concretes.Candidate;
import software.hrms.entities.concretes.CandidateAbility;
import software.hrms.entities.concretes.CandidateLanguage;
import software.hrms.entities.concretes.CandidateSchoolDepartment;
import software.hrms.entities.concretes.CandidateWorkplaceJobPosition;
import software.hrms.entities.concretes.CvDetail;
import software.hrms.entities.concretes.SocialMedia;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CvDto {

	@JsonIgnore
	private Candidate candidate;

	private List<CandidateSchoolDepartment> candidateSchoolDepartment;

	private List<CandidateWorkplaceJobPosition> candidateWorkplaceJobPosition;

	private List<CandidateLanguage> candidateLanguage;

	private List<CandidateAbility> candidateAbility;

	private List<SocialMedia> socialMedia;

	private CvDetail cvDetail;
}
