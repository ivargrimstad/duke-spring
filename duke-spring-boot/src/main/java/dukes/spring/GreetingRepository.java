package dukes.spring;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GreetingRepository extends CrudRepository<Greeting, Long> {
}
