package de.htw.webtech.hello.webtech.web;


import de.htw.webtech.hello.webtech.service.TaskService;
import de.htw.webtech.hello.webtech.web.api.Task;
import de.htw.webtech.hello.webtech.web.api.TaskManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@Validated
public class TaskRestController {

    private final TaskService taskService;

    public TaskRestController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(path = "/api/v1/task")
    public ResponseEntity<List<Task>> fetchTasks() {
        return ResponseEntity.ok(taskService.findAll());
    }

    @GetMapping(path = "/api/v1/task/{id}")
    public ResponseEntity<Task> fetchTaskById(@PathVariable Long id) {
        var task = taskService.findById(id);
        return task != null? ResponseEntity.ok(task) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/task")
    public ResponseEntity<Void> createTask(@RequestBody TaskManipulationRequest request) throws URISyntaxException {
        var task   = taskService.create(request);
        URI uri = new URI("/api/v1/task" + task.getId());
        return ResponseEntity.created(uri).build();
    }


    @PutMapping(path = "/api/v1/task/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody TaskManipulationRequest request) {
        var task = taskService.update(id, request);
        return task != null? ResponseEntity.ok(task) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/task/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        boolean successful = taskService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}