package hewe.shop.domain;

// default package

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * Teacher entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "teacher", catalog = "shop")
public class Teacher implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Double salary;
	private Set<Student> students = new HashSet<Student>(0);

	// Constructors

	/** default constructor */
	public Teacher() {
	}

	/** minimal constructor */
	public Teacher(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Teacher(Integer id, String name, Double salary, Set<Student> students) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.students = students;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "salary", precision = 22, scale = 0)
	public Double getSalary() {
		return this.salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	// { CascadeType.MERGE,CascadeType.REFRESH}
	@ManyToMany(fetch = FetchType.LAZY)
	@Cascade(value = { CascadeType.REFRESH, CascadeType.DETACH })
	@JoinTable(name = "teacher_student", catalog = "shop", joinColumns = {
			@JoinColumn(name = "teacher_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "student_id", nullable = false, updatable = false) })
	public Set<Student> getStudents() {
		return this.students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

}