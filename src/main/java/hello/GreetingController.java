package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RequestMapping(value = "/greeting")
@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    Logger logger = LoggerFactory.getLogger(GreetingController.class);

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = RequestMethod.GET)
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {

        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public ResponseEntity<Greeting> persistPerson(@RequestBody Greeting greeting) {

        return ResponseEntity.ok(greeting);

    }
}