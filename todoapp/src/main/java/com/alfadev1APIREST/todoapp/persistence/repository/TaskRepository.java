package com.alfadev1APIREST.todoapp.persistence.repository;

import com.alfadev1APIREST.todoapp.persistence.entity.Task;
import com.alfadev1APIREST.todoapp.persistence.entity.TaskStatus;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author cyka
 */
public interface TaskRepository extends JpaRepository<Task, Long> {    
    public List<Task> findAllByTaskStatus(TaskStatus taskStatus);   
    @Modifying
    @Query(value = "UPDATE TASK SET FINISHED=true WHERE ID=:id", nativeQuery = true)
    public void markTaskAsFinished(@Param("id") Long id);
    @Modifying
    @Query(value = "UPDATE TASK SET TASK_STATUS = 1 WHERE ID =:id", nativeQuery = true)
    public void taskStatusAsLate(@Param("id") Long id);
}
