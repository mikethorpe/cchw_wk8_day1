package models;


import javax.persistence.*;

@Entity
@Table(name = "routes")
public class Route {

	private int id;
	private String name;
	private String grade;
	private String description;

	public Route() {
	}


	public Route(String name, String grade, String description) {
		this.name = name;
		this.grade = grade;
		this.description = description;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int getId() {
		return id;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	@Column(name = "grade")
	public String getGrade() {
		return grade;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
