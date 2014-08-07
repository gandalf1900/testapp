package no.web.service;

import no.web.data.PersonRepository;
import no.web.model.Person;

import java.util.List;

public interface PersonService {

    public Person findPersonById(String id);

    public Person findPersonByEmail(String email);

    public List<Person> findPersons();

    public Person savePerson(Person person);
}
