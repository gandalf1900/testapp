package no.web.service;

import no.web.annotation.Repo;
import no.web.data.PersonRepository;
import no.web.model.Person;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
@Repo
public class RepoPersonService implements PersonService {

    @Inject
    private PersonRepository personRepository;

    @Override
    public Person savePerson(Person person) {
        return personRepository.savePerson(person);
    }

    @Override
    public Person findPersonById(final String id) {
        return personRepository.findPersonById(id);
    }

    @Override
    public Person findPersonByEmail(final String email) {
        return personRepository.findPersonByEmail(email);
    }

    @Override
    public List<Person> findPersons() {
        return personRepository.findAllPersons();
    }
}
