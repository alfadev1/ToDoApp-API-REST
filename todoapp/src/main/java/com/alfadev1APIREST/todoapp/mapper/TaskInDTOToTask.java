package com.alfadev1APIREST.todoapp.mapper;

import com.alfadev1APIREST.todoapp.persistence.entity.Task;
import com.alfadev1APIREST.todoapp.persistence.entity.TaskStatus;
import com.alfadev1APIREST.todoapp.service.dto.TaskInDTO;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

/**
 *
 * @author cyka
 */
@Component
public class TaskInDTOToTask implements Imapper<TaskInDTO, Task> {

    @Override
    public Task map(TaskInDTO in) {
        Task task = new Task();
        task.setTitle(in.getTitle());
        task.setDescription(in.getDescription());
        task.setEta(in.getEta());
        task.setCreatedDate(LocalDateTime.now());
        task.setFinished(false);
        task.setTaskStatus(TaskStatus.ON_TIME);
      return task;  
    }
    
    
}
