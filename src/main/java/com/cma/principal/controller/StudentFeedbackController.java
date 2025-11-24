package com.cma.principal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cma.principal.entity.StudentFeedback;
import com.cma.principal.service.StudentFeedbackService;

@RestController
@CrossOrigin(origins = "*")
public class StudentFeedbackController {
	
	@Autowired
	private StudentFeedbackService feedbackService;
	
	@PostMapping("/postStudentFeedback")
	public ResponseEntity<String> storeFeedback(@RequestBody StudentFeedback studentFeedback){
		try {
			
			String responseStatus = feedbackService.storeFeedbackService(studentFeedback);
			
			return new ResponseEntity<String>(responseStatus , HttpStatus.ACCEPTED);
			
		}catch(Exception ex) {
			
			return new ResponseEntity<String>(ex.getMessage(),HttpStatus.EXPECTATION_FAILED);
			
		}
		
	}

}