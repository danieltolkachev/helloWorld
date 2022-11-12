package de.htw.webtech.hello.webtech.web;




import de.htw.webtech.hello.webtech.web.api.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonRestController {

    private List<Person> persons;

    public PersonRestController(){
        persons = new ArrayList<>();
        persons.add(new Person(1, "Max", "Mustermann", false));
        persons.add(new Person(1, "Frank", "Müller", true));
    }

    @GetMapping(path = "/api/v1/persons")
    public ResponseEntity<List<Person>> fetchPersons(){
        return ResponseEntity.ok(persons);
    }
}

