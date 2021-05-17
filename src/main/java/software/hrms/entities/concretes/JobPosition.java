package software.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity 
@Table(name = "job_positions")
@NoArgsConstructor // Parametresiz constroctor
@AllArgsConstructor // Parametreli ctor

public class JobPosition {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "id")
	private int id;

	@Column(name = "title")
	private String title;

}