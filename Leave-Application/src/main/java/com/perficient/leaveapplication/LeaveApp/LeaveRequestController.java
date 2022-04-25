package com.perficient.leaveapplication.LeaveApp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LeaveRequestController {
	
	@Autowired
	LeaveRequestService leaveRequestService;

    private final Map<String, LeaveRequest> leaveRequests = new HashMap<>();

    @GetMapping("/leaveRequests/{id}")
    public ResponseEntity<LeaveRequest> getCustomer(@PathVariable String id) {
    	LeaveRequest leaveRequest = leaveRequests.get(id);
        System.out.println("Retrieved customer by id " + id + ") " + leaveRequest);

        if (leaveRequest != null) {
            return new ResponseEntity<>(leaveRequest, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/leaveRequests")
    public LeaveRequest createLeaveRequest(@RequestBody LeaveRequest createLeaveRequest) throws ParseException {
    	LeaveRequest leaveRequest = new LeaveRequest();
    	leaveRequest.setId(UUID.randomUUID().toString());
    	System.out.println("======="+createLeaveRequest.getEmployeeId());
    	System.out.println("======="+createLeaveRequest.getToDate());
    	System.out.println("createLeaveRequest.getNumberOfDays()"+createLeaveRequest.getNumberOfDays());
    	leaveRequest.setEmployeeId(createLeaveRequest.getEmployeeId());
    	leaveRequest.setEmployeeName(createLeaveRequest.getEmployeeName());
    	leaveRequest.setLeaveType(createLeaveRequest.getLeaveType());
    	leaveRequest.setFromDate(createLeaveRequest.getFromDate());
    	leaveRequest.setToDate(createLeaveRequest.getToDate());
    	leaveRequest.setNumberOfDays(createLeaveRequest.getNumberOfDays());
    	leaveRequest.setSupervisor(createLeaveRequest.getSupervisor());
    	leaveRequest.setStatus(createLeaveRequest.getStatus());
    	leaveRequests.put(leaveRequest.getId(), leaveRequest);
    	leaveRequestService.createLeaveRequest(leaveRequest);
        System.out.println("Created customer " + leaveRequest);
        return leaveRequest;
    }

    @PutMapping("/leaveRequests/{id}")
    public LeaveRequest updateLeaveRequest(@PathVariable String id, @RequestBody LeaveRequest createLeaveRequest) throws ParseException {
    	LeaveRequest leaveRequest = leaveRequests.get(id);
    	System.out.println(createLeaveRequest);
        leaveRequest.setEmployeeName(createLeaveRequest.getEmployeeName());
    	leaveRequest.setLeaveType(createLeaveRequest.getLeaveType());
    	leaveRequest.setFromDate(createLeaveRequest.getFromDate());
    	leaveRequest.setToDate(createLeaveRequest.getToDate());
    	leaveRequest.setNumberOfDays(createLeaveRequest.getNumberOfDays());
    	leaveRequest.setSupervisor(createLeaveRequest.getSupervisor());
    	leaveRequest.setStatus(createLeaveRequest.getStatus());
    	leaveRequestService.createLeaveRequest(leaveRequest);
        System.out.println("Updated customer to " + leaveRequest);
        return leaveRequest;
    }

    @DeleteMapping("/leaveRequests/{id}")
    public ResponseEntity deleteLeaveRequest(@PathVariable String id) {
    	LeaveRequest leaveRequest = leaveRequests.get(id);
        leaveRequestService.deleteLeaveRequest(leaveRequest);
        System.out.println("Deleted Leave Request " + leaveRequest);
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}