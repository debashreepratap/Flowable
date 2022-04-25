package com.perficient.leaveapplication.LeaveApp;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LeaveRequest {
	@Id
	private String id;
	
	@Column(name="emp_id")
	private String employeeId;
	@Column(name="emp_name")
	private String employeeName;
	private String leaveType;
	private Integer numberOfDays;
	private Date fromDate;
	private Date toDate;
	private String supervisor;
	private String status;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	public Integer getNumberOfDays() {
		return numberOfDays;
	}
	public void setNumberOfDays(Integer numberOfDays) {
		this.numberOfDays = numberOfDays;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public String getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "LeaveRequest [id=" + id + ", employeeId=" + employeeId + ", employeeName=" + employeeName + ", leaveType=" + leaveType
				+ ", numberOfDays=" + numberOfDays + ", fromDate=" + fromDate + ", toDate=" + toDate + ", supervisor="
				+ supervisor + ", status=" + status + "]";
	}
	
	
	
	

}
