package org.personal.api;

import org.personal.domain.Person;
import org.personal.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    @Autowired
    private LibraryService libraryService;


    @RequestMapping("/client/person")
    public Person getPerson() {
        Person person = new Person();

        person.setFirstName("John");
        person.setLastName("Doe");
        person.setAge(30);
        person.setBooks(libraryService.getBooks());

        return person;
    }
}