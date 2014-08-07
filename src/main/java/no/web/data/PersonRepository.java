package no.web.data;

import no.web.model.Person;

import java.util.List;

public interface PersonRepository {

    public Person savePerson(Person person);

    public Person findPersonById(String id);

    public Person findPersonByEmail(String email);

    public Person findPersonByFirstName(String email);

    public Person findPersonByLastName(String email);

    public List<Person> searchPersons(String query,int offset, int limit);

    public List<Person> findAllPersons();

    public void deletePerson(Person person);
}
