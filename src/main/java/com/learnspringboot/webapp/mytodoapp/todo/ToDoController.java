package com.learnspringboot.webapp.mytodoapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;


@Controller
@SessionAttributes("username")
public class ToDoController {
	
	private TodoService todoService;
	ToDoRepository todoRepo;
	
	
	public ToDoController(TodoService service, ToDoRepository repo) {
		super();
		this.todoService = service;
		this.todoRepo = repo;
	}
	
	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		String username = getCurrentUsername();
		List<Todo> todos = todoRepo.findByUsername(username);
		model.addAttribute("todos", todos);
		
		return "listTodos";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String showNewToDoPage(ModelMap model) {
		String username = getCurrentUsername();
		// Default Todo object 
		Todo defaultTodo = new Todo(0,username, "Default Desc", LocalDate.now().plusYears(1), false);
		model.put("todo", defaultTodo);
		return "addToDo";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String addNewTodo(@Valid Todo todo, ModelMap model, BindingResult result) {
		
		if(result.hasErrors()) return "addToDo";
		
		String username = getCurrentUsername();
		todo.setUsername(username);
		// insert todo to db
		todoRepo.save(todo);
		return "redirect:list-todos";
	}
	
	@RequestMapping("delete-todo")
	public String deleteToDo(@RequestParam int id) {
		todoRepo.deleteById(id);
		return "redirect:list-todos";
	}
	
	
	@RequestMapping(value="update-todo",method=RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		Todo todo = todoRepo.findById(id).get();
		model.addAttribute("todo", todo);
		return "addToDo";
	}
	 
	@RequestMapping(value="update-todo", method=RequestMethod.POST)
	public String updateTodo(Todo todo, ModelMap model) {
		
		String username = (String) model.get("username");
		todo.setUsername(username);
		todoRepo.save(todo);
		return "redirect:list-todos";
	}
	
	private String getCurrentUsername() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return auth.getName();
	}
	
}
