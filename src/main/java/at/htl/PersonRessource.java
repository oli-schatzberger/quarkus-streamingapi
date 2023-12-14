package at.htl;

import at.htl.Model.Person;
import at.htl.Repository.PersonRepo;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


import java.util.List;
import java.util.stream.Collectors;

@Path("/hello")
public class PersonRessource {

    @Inject
    PersonRepo personRepo;

    @GET
    @Path("/adults")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public List<String> getAdultsbyId() {
        List<Person> adult = personRepo.getPerson();

        return adult.stream()
                .map(Person::getName)
                .collect(Collectors.toList());
    }
}