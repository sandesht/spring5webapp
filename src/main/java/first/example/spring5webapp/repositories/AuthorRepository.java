package first.example.spring5webapp.repositories;

import first.example.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;


public interface AuthorRepository extends CrudRepository<Author,Long> {

}
