package no.web.service;

import no.web.annotation.InMemory;
import no.web.annotation.Mock;
import no.web.model.Person;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
@Mock
public class MockPersonService implements PersonService{
    @Override
    public Person findPersonById(final String id) {
        return null;
    }

    @Override
    public Person findPersonByEmail(final String email) {
        return null;
    }

    @Override
    public List<Person> findPersons() {
        return null;
    }

    @Override
    public Person savePerson(Person person) {
        return null;
    }
}
