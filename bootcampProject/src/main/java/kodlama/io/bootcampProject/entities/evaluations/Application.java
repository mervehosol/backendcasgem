package kodlama.io.bootcampProject.entities.evaluations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import kodlama.io.bootcampProject.entities.applications.Bootcamp;
import kodlama.io.bootcampProject.entities.users.Applicant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "applications")
public class Application {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "state")
	private int state;

	@ManyToOne
	@JoinColumn(name = "applicantId")
	private Applicant applicant;

	@ManyToOne
	@JoinColumn(name = "bootcampId")
	private Bootcamp bootcamp;

}


