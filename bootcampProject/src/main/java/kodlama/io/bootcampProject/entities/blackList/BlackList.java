package kodlama.io.bootcampProject.entities.blackList;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import kodlama.io.bootcampProject.entities.users.Applicant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="blacklists")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BlackList {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "date")
	private LocalDate date;
	
	@Column(name= "reason")
	private String reason;
	
	@ManyToOne
	@JoinColumn(name = "applicantId")
	private Applicant applicant;
	

}
