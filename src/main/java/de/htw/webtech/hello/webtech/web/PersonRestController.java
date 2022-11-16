package de.htw.webtech.hello.webtech.web;




import de.htw.webtech.hello.webtech.service.PersonService;
import de.htw.webtech.hello.webtech.web.api.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonRestController {

    private final PersonService personService;

    public PersonRestController(PersonService personService) {
        this.personService = personService;
    }


    @GetMapping(path = "/api/v1/persons")
    public ResponseEntity<List<Person>> fetchPersons(){
        return ResponseEntity.ok(personService.findAll());
    }
}

