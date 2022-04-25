package com.perficient.holidays.HolidaysManagementApp;

import lombok.Data;

@Data
public class HolidayRequest {

    String empName;

    Long noOfHolidays;

    String requestDescription;

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Long getNoOfHolidays() {
		return noOfHolidays;
	}

	public void setNoOfHolidays(Long noOfHolidays) {
		this.noOfHolidays = noOfHolidays;
	}

	public String getRequestDescription() {
		return requestDescription;
	}

	public void setRequestDescription(String requestDescription) {
		this.requestDescription = requestDescription;
	}

   
}