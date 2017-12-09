package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Greeting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String lang;
    private String greeting;

    protected Greeting() {}

    public Greeting(String lang, String greeting) {
        super();
        this.lang = lang;
        this.greeting = greeting;
    }

    /**
     * @return the lang
     */
    public String getLang() {
        return lang;
    }

    /**
     * @return the greeting
     */
    public String getGreeting() {
        return greeting;
    }

}