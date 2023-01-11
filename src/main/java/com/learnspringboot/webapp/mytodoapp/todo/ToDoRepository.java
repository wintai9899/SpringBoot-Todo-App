package com.learnspringboot.webapp.mytodoapp.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<Todo, Integer>{
	
	List<Todo> findByUsername(String username);
}
