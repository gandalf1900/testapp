package no.web.data;

import no.web.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class JpaPersonRepository implements PersonRepository{

    @PersistenceContext
    EntityManager em;

    @Override
    public Person savePerson(Person person) {
        em.persist(person);
        return person;
    }

    @Override
    public Person findPersonById(final String id) {
        Query query = em.createQuery("select c from Person c where c.id = :id");
        query.setParameter("id", id);
        return (Person) query.getSingleResult();
    }

    @Override
    public Person findPersonByEmail(final String email) {
        return null;
    }

    @Override
    public Person findPersonByFirstName(final String email) {
        return null;
    }

    @Override
    public Person findPersonByLastName(final String email) {
        return null;
    }

    @Override
    public List<Person> searchPersons(final String query, final int offset, final int limit) {
        return null;
    }

    @Override
    public List<Person> findAllPersons() {
        return null;
    }

    @Override
    public void deletePerson(final Person person) {
    }
}
