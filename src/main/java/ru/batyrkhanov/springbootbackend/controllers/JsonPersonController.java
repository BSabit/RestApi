package ru.batyrkhanov.springbootbackend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.batyrkhanov.springbootbackend.models.Person;

@RestController
public class JsonPersonController {

    @GetMapping
    public Person getPerson() {
        var person = new Person();
        person.setFullName("Павел");
        person.setHobby("Танцы");
        return person;
    }
}
