package com.perficient.flowable.work.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service(value = "receiveEventService")
public class ReceiveEventService {
	private static final Logger log = LoggerFactory.getLogger(ReceiveEventService.class);

	public void start() {
		log.info("Received");
	}
}
