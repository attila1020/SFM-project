package hu.unideb.gasstation.api.controllers;

import hu.unideb.gasstation.models.Person;
import hu.unideb.gasstation.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @GetMapping("/person")
    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    @GetMapping("/person/{id}")
    public Optional<Person> getPersonById(@PathVariable long id) {
        return personRepository.findById(id);
    }

    @PostMapping("/person/{id}")
    public boolean updatePerson(@PathVariable long id, @RequestBody Person person) {
        if (personRepository.findById(id).orElse(null) != null) {
            personRepository.save(person);
            return true;
        }
        else {
            return false;
        }
    }

    @DeleteMapping("/person/{id}")
    public boolean deletePerson(@PathVariable long id) {
        if (personRepository.findById(id).orElse(null) != null) {
            personRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }
}
