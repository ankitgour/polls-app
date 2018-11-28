package com.rest.webservices.pollswebservice.polls;


import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Poll {
	
	@Id
    @GeneratedValue
    @Column(name="POLL_ID")
	@JsonIgnore
    private Integer id;

    @Column(name="QUESTION")
    @javax.validation.constraints.NotEmpty
    private String question;

    
    @Past
	private Date published_at;
    
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="POLL_ID")
    @OrderBy
    private Set<Choice> choices;
    
    public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	public Set<Choice> getChoices() {
		return choices;
	}


	public void setChoices(Set<Choice> choices) {
		this.choices = choices;
	}
	
	public Date getPublished_at() {
		return published_at;
	}

	public void setPublished_at(Date Published_at) {
		this.published_at = Published_at;
	}
    
}
