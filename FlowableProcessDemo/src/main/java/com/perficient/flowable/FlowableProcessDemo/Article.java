package com.perficient.flowable.FlowableProcessDemo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Article {
	
	@Id
    @GeneratedValue
	private Long id;
	
	private String author;

	private String url;
	
	public Article() {
		super();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Article(String author, String url) {
		super();
		this.author = author;
		this.url = url;
	}
	
	
}
