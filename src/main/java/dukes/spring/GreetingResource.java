package dukes.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class GreetingResource {

    @Autowired
    private GreetingRepository greetingRepository;

    @GetMapping(value = "/greetings", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Greeting> findAll() {

        return StreamSupport.stream(greetingRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @PostMapping(value = "/greetings", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addGreeting(@RequestBody Greeting greeting) {

        Greeting saved = greetingRepository.save(greeting);
        return ResponseEntity.ok( "Greeting saved with id: " + saved.getId());
    }
}
