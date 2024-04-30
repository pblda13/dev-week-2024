package me.dio.devweek.controller;


import jakarta.validation.Valid;
import me.dio.devweek.entity.Todo;
import me.dio.devweek.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    private TodoService todoService;

    @PostMapping
    List<Todo>create(@RequestBody @Valid Todo todo){
        return todoService.create(todo);
    }

    @GetMapping
    List<Todo>list(){
        return todoService.list();
    }

    @PutMapping
    List<Todo>update(@RequestBody Todo todo){
        return todoService.update(todo);
    }

    @DeleteMapping("{id}")
    List<Todo>delete(@PathVariable("id") Long id){
        return todoService.delete(id);
    }
}
