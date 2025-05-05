package com.example.modelSe;

import java.io.Serializable;


public class User {
	
//	private static final long serialVersionUID = 1L;
	
	private Long id;
    private Integer age;
    private String content;
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", age=" + age + ", content=" + content + "]";
	}
	
    
    

}
