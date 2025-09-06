package com.Project.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SurveyDetails {
	@Id
	private String SurveyID;
	private String email;
	private String question;
	public String getSurveyID() {
		return SurveyID;
	}
	public void setSurveyID(String surveyID) {
		SurveyID = surveyID;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	@Override
	public String toString() {
		return "SurveyDetails [SurveyID=" + SurveyID + ", question=" + question + "]";
	}
	
}
