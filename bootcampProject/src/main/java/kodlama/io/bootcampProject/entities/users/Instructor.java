package kodlama.io.bootcampProject.entities.users;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import kodlama.io.bootcampProject.entities.applications.Bootcamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "instructors")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Instructor extends User {


	@Column(name = "companyName")
	private String companyName;
	
	@OneToMany(mappedBy= "instructor")
	private List<Bootcamp> bootcamps;

	

}
