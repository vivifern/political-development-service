package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Development {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Min(1)
	@Max(99999)
	private Long leaderId;
	@Min(1)
	@Max(999)
	private Integer partyId;
	@Size(min = 5, max = 100)
	@Pattern(regexp = "^[a-zA-z\\s]*$")
	private String developmentTitle;
	@Size(min = 5, max = 100)
	@Pattern(regexp = "^[a-zA-z\\s]*$")
	private String activity;
	@Min(1)
	@Max(999999999)
	private Long budget;
	@Size(min = 3, max=50)
	@Pattern(regexp = "^[a-zA-z\\s]*$")
	private String state;
	@Min(1)
	@Max(12)
	private Byte activityMonth;
	@Min(2022)
	@Max(2027)
	private Short activityYear;
	
	protected Development() {
	}

	public Development(Long leaderId, Integer partyId, String developmentTitle, String activity, Long budget,
			String state, Byte activityMonth, Short activityYear) {
		super();
		this.leaderId = leaderId;
		this.partyId = partyId;
		this.developmentTitle = developmentTitle;
		this.activity = activity;
		this.budget = budget;
		this.state = state;
		this.activityMonth = activityMonth;
		this.activityYear = activityYear;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getLeaderId() {
		return leaderId;
	}

	public void setLeaderId(Long leaderId) {
		this.leaderId = leaderId;
	}

	public Integer getPartyId() {
		return partyId;
	}

	public void setPartyId(Integer partyId) {
		this.partyId = partyId;
	}

	public String getDevelopmentTitle() {
		return developmentTitle;
	}

	public void setDevelopmentTitle(String developmentTitle) {
		this.developmentTitle = developmentTitle;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public Long getBudget() {
		return budget;
	}

	public void setBudget(Long budget) {
		this.budget = budget;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Byte getActivityMonth() {
		return activityMonth;
	}

	public void setActivityMonth(Byte activityMonth) {
		this.activityMonth = activityMonth;
	}

	public Short getActivityYear() {
		return activityYear;
	}

	public void setActivityYear(Short activityYear) {
		this.activityYear = activityYear;
	}

	@Override
	public String toString() {
		return "Development [id=" + id + ", leaderId=" + leaderId + ", partyId=" + partyId + ", developmentTitle="
				+ developmentTitle + ", activity=" + activity + ", budget=" + budget + ", state=" + state
				+ ", activityMonth=" + activityMonth + ", activityYear=" + activityYear + "]";
	}
	
}
