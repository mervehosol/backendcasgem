package kodlama.io.bootcampProject.entities.users;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import kodlama.io.bootcampProject.entities.blackList.BlackList;
import kodlama.io.bootcampProject.entities.evaluations.Application;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "applicants")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Applicant extends User {
	@Column(name = "about")
	private String about;
	
	@OneToMany(mappedBy = "applicant")
	private List<Application> applications;
	
	@OneToMany(mappedBy = "applicant")
	private List<BlackList> blackLists;
}
