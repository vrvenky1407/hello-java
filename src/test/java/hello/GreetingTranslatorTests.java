package hello;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * GreetingTranslatorTests
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GreetingTranslatorTests {
    @Autowired
    private GreetingTranslator translator;

    @Autowired
    private GreetingRepository repository;

    @Test
    public void testAddGreeting() {
        long numberOfGreetings = repository.count();
        Greeting greeting = new Greeting("en", "Hello");
        translator.add(greeting);

        long newNumberOfGreetings = repository.count();
        assertThat(newNumberOfGreetings).isEqualTo(numberOfGreetings+1);
    }

    @Test
    public void testGreeting() {
        Greeting greeting = new Greeting("en", "Hello");
        translator.add(greeting);

        String hello = translator.sayHelloIn(greeting.getLang());
        assertThat(hello).isEqualTo(greeting.getGreeting());
    }
    
}