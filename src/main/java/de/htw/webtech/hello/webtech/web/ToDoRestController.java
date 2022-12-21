package de.htw.webtech.hello.webtech.web;


import de.htw.webtech.hello.webtech.service.ToDoService;
import de.htw.webtech.hello.webtech.web.api.ToDo;
import de.htw.webtech.hello.webtech.web.api.ToDoManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@Validated
public class ToDoRestController {

    private final ToDoService toDoService;

    public ToDoRestController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping(path = "/api/v1/todo")
    public ResponseEntity<List<ToDo>> fetchToDos() {
        return ResponseEntity.ok(toDoService.findAll());
    }

    @GetMapping(path = "/api/v1/todo/{id}")
    public ResponseEntity<ToDo> fetchToDoById(@PathVariable Long id) {
        var toDo = toDoService.findById(id);
        return toDo != null? ResponseEntity.ok(toDo) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/todo")
    public ResponseEntity<Void> creatToDo(@RequestBody ToDoManipulationRequest request) throws URISyntaxException {
        var toDo   = toDoService.create(request);
        URI uri = new URI("/api/v1/todo" + toDo.getId());
        return ResponseEntity.created(uri).build();
    }


    @PutMapping(path = "/api/v1/todo/{id}")
    public ResponseEntity<ToDo> updateToDo(@PathVariable Long id, @RequestBody ToDoManipulationRequest request) {
        var toDo = toDoService.update(id, request);
        return toDo != null? ResponseEntity.ok(toDo) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/todo/{id}")
    public ResponseEntity<Void> deleteToDo(@PathVariable Long id){
        boolean successful = toDoService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}