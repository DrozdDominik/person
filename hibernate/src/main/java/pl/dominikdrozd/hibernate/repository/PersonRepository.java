package pl.dominikdrozd.hibernate.repository;

import org.springframework.data.repository.CrudRepository;
import pl.dominikdrozd.hibernate.model.Person;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long>{
    List<Person> findBySurname(String surname);
    List<Person> findByName(String name);
}
