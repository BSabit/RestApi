package ru.batyrkhanov.springbootbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.batyrkhanov.springbootbackend.models.Person;
import ru.batyrkhanov.springbootbackend.repositories.PeopleRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PeopleService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<Person> findAll() {
        return peopleRepository.findAll();
    }

    public Person findOne(int id) {
        Optional<Person> foundPerson = peopleRepository.findById(id);
        return foundPerson.orElse(null);
    }

    @Transactional
    public Person save(Person person) {
        peopleRepository.save(person);
        return person;
    }

    @Transactional
    public void update(int id, Person updatedPerson) {
        updatedPerson.setId(id);
        peopleRepository.save(updatedPerson);
    }

    @Transactional
    public void delete(Person person) {
        peopleRepository.delete(person);
    }
}
