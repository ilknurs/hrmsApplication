package software.hrms.entities.concretes;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "activation_codes")
public class ActivationCode {

	public ActivationCode(int userId, String activationCode) {
		super();
		this.userId = userId;
		this.activationCode = activationCode;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "activation_code")
	private String activationCode;

	@Column(name = "expiration_date")
	private LocalDateTime expirationDate;

	@Column(name = "is_confirmed")
	private boolean isConfirmed = false;

	@Column(name = "activation_date")
	private LocalDateTime activationDate;

	@CreatedDate
	@Column(name = "created_date")
	private LocalDateTime createdDate =LocalDateTime.now();

	@LastModifiedDate
	@Column(name = "updated_date")
	private LocalDateTime updatedDate;

	@Column(name = "status")
	private boolean status = true;

}