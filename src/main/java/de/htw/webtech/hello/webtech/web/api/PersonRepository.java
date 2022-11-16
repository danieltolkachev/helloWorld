package de.htw.webtech.hello.webtech.web.api;

import de.htw.webtech.hello.webtech.persistence.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

    List<PersonEntity> findAllByFirstName(String firstName);

}
