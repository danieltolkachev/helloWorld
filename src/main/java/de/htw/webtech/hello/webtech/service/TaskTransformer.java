package de.htw.webtech.hello.webtech.service;

import de.htw.webtech.hello.webtech.persistence.TaskEntity;
import de.htw.webtech.hello.webtech.web.api.Task;
import org.springframework.stereotype.Service;

@Service
public class TaskTransformer {

    public Task transformEntity(TaskEntity taskEntity) {
        return new Task(
                taskEntity.getId(),
                taskEntity.getTitle(),
                taskEntity.getDescription(),
                taskEntity.getFavorite());
    }
}