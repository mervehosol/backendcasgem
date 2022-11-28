package kodlama.io.bootcampProject.entities.applications;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import kodlama.io.bootcampProject.entities.evaluations.Application;
import kodlama.io.bootcampProject.entities.users.Instructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name="bootcamps")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Bootcamp {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="dateStart")
	private int dateStart;
	
	@Column(name="dateEnd")
	private int dateEnd;
	
	@Column(name="state")
	private int state;
	
	@ManyToOne
	@JoinColumn(name="instructorId")
	private Instructor instructor;
	
	@OneToMany(mappedBy ="bootcamp")
	private List<Application> applications;
	
	
	
}	
