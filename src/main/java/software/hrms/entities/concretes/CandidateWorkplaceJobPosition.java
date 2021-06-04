package software.hrms.entities.concretes;

import java.time.LocalDate;
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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "candidates_workplaces_job_positions")
public class CandidateWorkplaceJobPosition {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "candidate_workplace_id")
	private int candidateWorkPlaceId;

	@Column(name = "date_of_entry")
	private LocalDate dateOfEntry;

	@Column(name = "date_of_quit")
	private LocalDate dateOfQuit;

	@ManyToOne
	@JoinColumn(name = "workplace_id")
	private Workplace workplace;

	@ManyToOne
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;

	@ManyToOne
	@JoinColumn(name = "job_position_id")
	private JobPosition jobPosition;

}
