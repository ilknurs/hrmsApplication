package software.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "candidates_languages")
public class CandidateLanguage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="candidate_language_id")
	private int candidateLanguageId;
	
	@ManyToOne
	@JoinColumn(name="candidate_id")
	private Candidate candidate;

	@ManyToOne
	@JoinColumn(name="language_id")
	private Language language;
	
	@ManyToOne
	@JoinColumn(name="language_level_id")
	private LanguageLevel languageLevel;

}
