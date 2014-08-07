package no.web.faces;

import no.web.model.Person;
import no.web.service.PersonService;
import no.web.annotation.Repo;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class PersonWizard {
    private String firstName;
    private String lastName;
    private String email;

    @Inject private @Repo PersonService personService;

    public void save() {
        Person person = new Person();
        personService.savePerson(person);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }
}
