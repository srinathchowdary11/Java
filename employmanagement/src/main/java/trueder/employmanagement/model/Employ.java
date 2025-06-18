package trueder.employmanagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

//import lombok.Data;
@Data
@Entity
@Table(name = "emp_details")
public class Employ  {

	@Id
	private int employId;
	@Column
	private String employName;
	@Column
	private String employDesignation;
	@Column
	private long employSalary;
	public int getEmployId() {
		return employId;
	}
	public void setEmployId(int employId) {
		this.employId = employId;
	}
	public String getEmployName() {
		return employName;
	}
	public void setEmployName(String employName) {
		this.employName = employName;
	}
	public String getEmployDesignation() {
		return employDesignation;
	}
	public void setEmployDesignation(String employDesignation) {
		this.employDesignation = employDesignation;
	}
	public long getEmploySalary() {
		return employSalary;
	}
	public void setEmploySalary(long employSalary) {
		this.employSalary = employSalary;
	}
	
	
}
