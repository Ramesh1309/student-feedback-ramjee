package com.cma.principal.service;

import java.lang.reflect.Type;
import java.util.List;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cma.principal.entity.StudentFeedback;
import com.cma.principal.entity.StudentFeedbackDBEntity;
import com.cma.principal.entity.StudentResponse;
import com.cma.principal.jpa.StudentFeedbackResponseJPA;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import jakarta.transaction.Transactional;



@Service
public class StudentFeedbackService {
	
	@Autowired
	private StudentFeedbackResponseJPA repo;
	
	public String storeFeedbackService(StudentFeedback studentFeedback) {
		
		try {
			
			Gson gs = new Gson();
			
			
			 Type listType = new TypeToken<List<StudentResponse>>() {}.getType();
			 List<StudentResponse> studentRespList = gs.fromJson(studentFeedback.getStudentResponse(), listType);
			
			saveFeedbackResponse(studentFeedback.getStudentName(),
					studentFeedback.getStudentId()
					, studentFeedback.getStudentGrade(), studentFeedback.getStudentSection(),studentRespList);
			
			return "Thanks "+studentFeedback.getStudentName()+" for your feedback";
			
			
		}catch(Exception ex) {
			return "Sorry, some inconvience try again after sometime {} Reason - "+ex.getMessage();
		}
		
		
		
	
		
		
		
	}
	
	@Transactional
	public StudentFeedbackDBEntity saveFeedbackResponse(String studentName, String studentID, String studentGrade,
			String studentSection, List<StudentResponse> studentResponse) {
		
		StudentFeedbackDBEntity feedbackEntity = new StudentFeedbackDBEntity();
		feedbackEntity.setStudentGrade(studentGrade);
		feedbackEntity.setStudentID(studentID);
		feedbackEntity.setStudentName(studentName);
		feedbackEntity.setStudentSection(studentSection);
		feedbackEntity.setStudentResponse(studentResponse);
		
		
		return repo.save(feedbackEntity);
	}
	
	

}
