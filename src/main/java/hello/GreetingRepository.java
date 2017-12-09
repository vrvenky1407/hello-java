package hello;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 * GreetingRepository
 */
public interface GreetingRepository extends CrudRepository<Greeting, Long> {
    List<Greeting> findByLang(String lang);    
}