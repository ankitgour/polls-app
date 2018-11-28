package com.rest.webservices.pollswebservice.polls;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Choice {

	@Id
    @GeneratedValue
    @Column(name="OPTION_ID")
    private Integer votes;
	
	@Column(name="OPTION_VALUE")
    private String choice;

	public Integer getVotes() {
		return votes;
	}

	public void setVotes(Integer votes) {
		this.votes = votes;
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String Choice) {
		this.choice = Choice;
	}

		

}
