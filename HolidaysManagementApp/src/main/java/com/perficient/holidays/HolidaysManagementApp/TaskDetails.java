package com.perficient.holidays.HolidaysManagementApp;

import java.io.Serializable;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String taskId;
	String taskName;
	Map<String, Object> taskData;

	public TaskDetails(String taskId, String taskName, Map<String, Object> taskData) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.taskData = taskData;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Map<String, Object> getTaskData() {
		return taskData;
	}

	public void setTaskData(Map<String, Object> taskData) {
		this.taskData = taskData;
	}

}