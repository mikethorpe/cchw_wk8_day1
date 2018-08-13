package models;


import javax.persistence.*;

@Entity
@Table(name = "climbers")
public class Climber {

	private int id;
	private String name;
	private int age;
	private String climbingStyle;

	public Climber() {
	}

	public Climber(String name, int age, String climbingStyle) {
		this.name = name;
		this.age = age;
		this.climbingStyle = climbingStyle;
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

	@Column(name = "age")
	public int getAge() {
		return age;
	}

	@Column(name = "climbing_style")
	public String getClimbingStyle() {
		return climbingStyle;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setClimbingStyle(String climbingStyle) {
		this.climbingStyle = climbingStyle;
	}
}
