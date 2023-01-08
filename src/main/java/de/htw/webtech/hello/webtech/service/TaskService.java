package de.htw.webtech.hello.webtech.service;

import de.htw.webtech.hello.webtech.persistence.TaskEntity;
import de.htw.webtech.hello.webtech.persistence.TaskRepository;
import de.htw.webtech.hello.webtech.web.api.Task;
import de.htw.webtech.hello.webtech.web.api.TaskManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskTransformer taskTransformer;

    public TaskService(TaskRepository taskRepository, TaskTransformer taskTransformer) {
        this.taskRepository = taskRepository;
        this.taskTransformer = taskTransformer;
    }

    public List<Task> findAll(){
        List<TaskEntity> tasks = taskRepository.findAll();
        return tasks.stream()
                .map(taskTransformer::transformEntity)
                .collect(Collectors.toList());
    }

    public Task findById(Long id){
        var taskEntity = taskRepository.findById(id);
        return taskEntity.map(taskTransformer::transformEntity).orElse(null);
    }

    public Task create(TaskManipulationRequest request) {
        var taskEntity = new TaskEntity(request.getTitle(), request.getDescription(), request.getFavorite());
        taskEntity = taskRepository.save(taskEntity);
        return taskTransformer.transformEntity(taskEntity);
    }

    public Task update(Long id, TaskManipulationRequest request){
        var taskEntityOptional = taskRepository.findById(id);
        if (taskEntityOptional.isEmpty()) {
            return null;
        }
        var taskEntity = taskEntityOptional.get();
        taskEntity.setTitle(request.getTitle());
        taskEntity.setDescription(request.getDescription());
        taskEntity.setFavorite(request.getFavorite());
        taskEntity = taskRepository.save(taskEntity);
        return taskTransformer.transformEntity(taskEntity);
    }

    public boolean deleteById(Long id){
        if(!taskRepository.existsById(id)){
            return false;
        }

        taskRepository.deleteById(id);
        return true;
    }
}