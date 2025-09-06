package com.Project.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Options {
	@Id
	private String Op;
	private String SurveyID;
	private int percent;
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
	public int getPercent() {
		return percent;
	}
	public void setPercent(int percent) {
		this.percent = percent;
	}
	
}