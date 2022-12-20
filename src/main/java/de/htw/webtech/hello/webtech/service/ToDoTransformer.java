package de.htw.webtech.hello.webtech.service;

import de.htw.webtech.hello.webtech.persistence.ToDoEntity;
import de.htw.webtech.hello.webtech.web.api.ToDo;
import org.springframework.stereotype.Service;

@Service
public class ToDoTransformer {

    public ToDo transformEntity(ToDoEntity toDoEntity) {
        return new ToDo(
                toDoEntity.getId(),
                toDoEntity.getTitel(),
                toDoEntity.getDescription(),
                toDoEntity.getDate(),
                toDoEntity.getFinished(),
                toDoEntity.getFavorite());
    }
}