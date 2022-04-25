package com.perficient.KafkaConsumerExample;

public class User {
	
	private String name;
	private String department;
	private Long salary;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Long getSalary() {
		return salary;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	public User(String name, String department, Long salary) {
		this.name = name;
		this.department = department;
		this.salary = salary;
	}
	public User() {
		
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", department=" + department + ", salary=" + salary + "]";
	}
	
  
}
