package software.hrms.entities.abstracts;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users")

public abstract class User {
	

    public User(String email, String password){
        this.email = email;
        this.password=password;
    }

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	
	@Column(name = "created_date")
	private LocalDateTime createdDate = LocalDateTime.now();
	
	
	@Column(name = "updated_date")
	private LocalDateTime updatedDate;
	
	@Column(name = "status")
	private boolean status = true;

}
