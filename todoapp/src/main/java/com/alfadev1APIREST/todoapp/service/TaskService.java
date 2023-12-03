package com.alfadev1APIREST.todoapp.service;

import com.alfadev1APIREST.todoapp.exceptions.ToDoExceptions;
import com.alfadev1APIREST.todoapp.mapper.TaskInDTOToTask;
import com.alfadev1APIREST.todoapp.persistence.entity.Task;
import com.alfadev1APIREST.todoapp.persistence.entity.TaskStatus;
import com.alfadev1APIREST.todoapp.persistence.repository.TaskRepository;
import com.alfadev1APIREST.todoapp.service.dto.TaskInDTO;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 *
 * @author cyka
 */
@Service
public class TaskService {

    private final TaskRepository repository;
    private final TaskInDTOToTask mapper;

    public TaskService(TaskRepository repository, TaskInDTOToTask mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Task createTask(TaskInDTO taskInDTO) {
        Task task = mapper.map(taskInDTO);
        return this.repository.save(task);
    }

    public List<Task> findAll() {
        return this.repository.findAll();
    }

    public List<Task> findAllByTaskStatus(TaskStatus taskStatus) {
        return this.repository.findAllByTaskStatus(taskStatus);
    }

    @Transactional
    public void markTaskAsFinished(Long id) {
        Optional<Task> optionalTask = this.repository.findById(id);
        if (optionalTask.isEmpty()) {
            throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }
        this.repository.markTaskAsFinished(id);
    }

    public void deleteById(Long id) {
        Optional<Task> optionalTask = this.repository.findById(id);
        if (optionalTask.isEmpty()) {
            throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }
        this.repository.deleteById(id);
    }

    @Transactional
    public void taskStatusAsLate(Long id) {
        Optional<Task> optionalTask = this.repository.findById(id);
        if (optionalTask.isEmpty()) {
            throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }
        this.repository.taskStatusAsLate(id);
    }
    
    @Transactional
    public void updateAllByTaskStatusAndIfIsFinalized() {
        this.repository.updateAllByTaskStatusAndIfIsFinalized();
    }

}
