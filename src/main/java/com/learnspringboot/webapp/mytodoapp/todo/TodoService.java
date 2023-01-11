package com.learnspringboot.webapp.mytodoapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;


@Service
public class TodoService {
	
	private static int todoCount = 0;
	private static List<Todo> todoList = new ArrayList<>(); 

	
	
	public List<Todo> getTodoList(){
		return todoList;
	}
	
	
	public void addTodo(String username, String description, LocalDate targetDate,boolean isCompleted ) {
		Todo newTodo = new Todo(++todoCount,username, description, targetDate, isCompleted);
		todoList.add(newTodo); 
	}
	
	public void deleteToDo(int id) {
		todoList.removeIf(todo -> todo.getId() == id);
	}
	
	public void updateTodo(Todo todo) {
		deleteToDo(todo.getId());
		todoList.add(todo);
	}
	
	public Todo findById(int id) {
		
		Todo targetTodo = todoList.stream().filter(todo -> todo.getId() == id).findFirst().get();
		return targetTodo; 
	}
	
//	public List<Todo> findByUsername(String username) {
//		
//		return todoList.stream().filter(todo -> todo.getUsername().equalsIgnoreCase(username)).toList();
//	}
}
