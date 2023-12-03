package com.alfadev1APIREST.todoapp.controller;

import com.alfadev1APIREST.todoapp.persistence.entity.Task;
import com.alfadev1APIREST.todoapp.persistence.entity.TaskStatus;
import com.alfadev1APIREST.todoapp.service.TaskService;
import com.alfadev1APIREST.todoapp.service.dto.TaskInDTO;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cyka
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping
    public Task createTask(@RequestBody TaskInDTO taskInDTO) {
        return this.service.createTask(taskInDTO);
    }

    @GetMapping
    public List<Task> findAll() {
        return this.service.findAll();
    }

    @GetMapping("/status/{taskStatus}")
    public List<Task> findAllByTaskStatus(@PathVariable("taskStatus") TaskStatus status) {
        return this.service.findAllByTaskStatus(status);
    }

    @PatchMapping("/markAsFinished/{id}")
    public ResponseEntity<Void> markAsFinished(@PathVariable("id") Long id) {
        this.service.markTaskAsFinished(id);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        this.service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @PatchMapping("/taskStatusAsLate/{id}")
    public ResponseEntity<Void> taskStatusAsLate(@PathVariable("id") Long id) {
        this.service.taskStatusAsLate(id);
        return ResponseEntity.noContent().build();
    }
    @PatchMapping
    public ResponseEntity<Void> updateAllByTaskStatusAndIfIsFinalized() {
        this.service.updateAllByTaskStatusAndIfIsFinalized();
        return ResponseEntity.noContent().build();        
    }
}
