package com.alfadev1APIREST.todoapp.service.dto;

import com.alfadev1APIREST.todoapp.persistence.entity.TaskStatus;
import java.time.LocalDateTime;
import lombok.Data;

/**
 *
 * @author cyka
 */
@Data
public class TaskInDTO {
   
    private String title;
    private String description;    
    private LocalDateTime eta;    
    
}
