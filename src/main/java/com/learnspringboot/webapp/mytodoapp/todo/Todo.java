package com.learnspringboot.webapp.mytodoapp.todo;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity(name = "TODO_TABLE")
public class Todo {
	@Id
	@GeneratedValue
	private int id; 
	@Column(name="USERNAME")
	private String username; 
	
	@NotNull(message ="Description cant be empty")
	@Column(name="DESCRIPTION")
	private String description; 
	
	private LocalDate targetDate;
	@Column(name="IS_COMPLETED")
	private boolean isCompleted;
	
	public Todo() {};
	
	public Todo(int id, String username, String description, LocalDate targetDate, boolean isCompleted) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.targetDate = targetDate;
		this.isCompleted = isCompleted;
	}
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}
	public boolean getisCompleted() {
		return isCompleted;
	}
	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	
	@Override
	public String toString() {
		return "Todo [id=" + id + ", username=" + username + ", description=" + description + ", targetDate="
				+ targetDate + ", isCompleted=" + isCompleted + "]";
	} 
	
	
	

}
