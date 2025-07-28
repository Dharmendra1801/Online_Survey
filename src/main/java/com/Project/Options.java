package com.Project;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Options {
	@Id
	private String Op;
	private String SurveyID;
	public String getOption() {
		return Op;
	}
	public void setOption(String option) {
		Op = option;
	}
	public String getSurveyID() {
		return SurveyID;
	}
	public void setSurveyID(String surveyID) {
		SurveyID = surveyID;
	}
}