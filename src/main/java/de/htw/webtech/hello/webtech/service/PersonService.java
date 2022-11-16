package de.htw.webtech.hello.webtech.service;

import de.htw.webtech.hello.webtech.persistence.PersonEntity;
import de.htw.webtech.hello.webtech.web.api.Person;
import de.htw.webtech.hello.webtech.web.api.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAll() {
        List<PersonEntity> persons = personRepository.findAll();
        return persons.stream()
                .map(personEntity -> new Person(
                        personEntity.getId(),
                        personEntity.getFirstName(),
                        personEntity.getLastName(),
                        personEntity.getVaccinated())
                )
                .collect(Collectors.toList());
    }
}