package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "feedback")
public class Feedback {
	@Id
	@SequenceGenerator(name = "feed_seq1", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "feed_seq1", strategy = GenerationType.SEQUENCE)
	int feedId;
	String feed;

	public String getFeed() {
		return feed;
	}

	public void setFeed(String feed) {
		this.feed = feed;
	}
	
}
