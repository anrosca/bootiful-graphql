package inc.evil.graphql.web;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GreetingsController {
    @QueryMapping
    public List<Customer> customers() {
        return List.of(
                new Customer(1, "Mike", new Account(100, "Savings"), 27),
                new Customer(2, "John", new Account(101, "Spending"), 46)
        );
    }

    @QueryMapping
    public Customer customerById(@Argument Integer id) {
        return new Customer(id, "Mike", new Account(100, "Savings"), 27);
    }

    @QueryMapping
    public String hello() {
        return "Hello, world!";
    }

    @QueryMapping
    public String helloWithName(@Argument String name) {
        return "Hello, " + name + "!";
    }
}
