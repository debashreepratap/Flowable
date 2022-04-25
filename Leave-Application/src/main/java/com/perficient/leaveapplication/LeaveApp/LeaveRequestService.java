package com.perficient.leaveapplication.LeaveApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaveRequestService {
	 @Autowired
	 LeaveRequestRepository leaveRequestRepository;

	public void createLeaveRequest(LeaveRequest leaveRequest) {
		leaveRequestRepository.save(leaveRequest);
		
	}

	public void deleteLeaveRequest(LeaveRequest leaveRequest) {
		leaveRequestRepository.delete(leaveRequest);
		
	}

}
