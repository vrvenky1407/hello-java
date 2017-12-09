package hello;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class GreetingTranslator {

	@Autowired
	private GreetingRepository repository;
	
	public String sayHelloIn(String lang) {
		String hello;
		List<Greeting> greetings = repository.findByLang(lang);
		
		if (greetings == null || greetings.isEmpty()) {
			hello = "no hablo tu idioma";			
		} else {
			hello = greetings.get(0).getGreeting();
		}

		return hello;
	}

	public Greeting add(Greeting newGreeting) {
		return repository.save(newGreeting);
	}

}