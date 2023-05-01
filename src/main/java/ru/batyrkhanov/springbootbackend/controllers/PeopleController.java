package ru.batyrkhanov.springbootbackend.controllers;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.batyrkhanov.springbootbackend.models.Person;
import ru.batyrkhanov.springbootbackend.services.PeopleService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/people")
public class PeopleController {

    private final PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }


//    @GetMapping
//    public String index(Model model) {
//        model.addAttribute("people", peopleService.findAll());
//
//        return "people/index";
//    }

    @GetMapping
    List<Person> findAll() {
        return peopleService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getOne(@PathVariable("id") Person person) {
        return ResponseEntity.ok(person);
    }





//    @GetMapping("new")
//    public String newPerson(Model model) {
//        model.addAttribute("person", new Person());
//
//        return "people/new";
//    }

    @PostMapping
    public Person create(@RequestBody Person person) {
        person.setCreatedAt(LocalDateTime.now());
        return peopleService.save(person);
    }

//    @GetMapping("/{id}/edit")
//    public String edit(Model model, @PathVariable("id") int id) {
//        model.addAttribute("person", peopleService.findOne(id));
//
//        return "people/edit";
//    }

    @PutMapping("/{id}")
    public Person update(@PathVariable("id") Person personFromDB, @RequestBody Person person) {
        BeanUtils.copyProperties(person, personFromDB, "id");
        return peopleService.save(personFromDB);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Person person) {
        peopleService.delete(person);
    }
}
