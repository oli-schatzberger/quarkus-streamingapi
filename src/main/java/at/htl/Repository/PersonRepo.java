package at.htl.Repository;

import at.htl.Model.Person;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@ApplicationScoped
public class PersonRepo {
    @Inject
    EntityManager entityManager;

    public List<Person> getPerson() {
        return entityManager.createQuery("SELECT p FROM Person p WHERE p.age >= 18", Person.class).getResultList();
    }


}
