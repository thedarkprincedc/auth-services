package auth;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class AuthController {

    private static final String TEMPLATE = "Hello, %s!";

    @RequestMapping("/greeting")
    public HttpEntity<Auth> greeting(
            @RequestParam(value = "name", required = false, defaultValue = "World") String name) {

        Auth greeting = new Auth(String.format(TEMPLATE, name));
        greeting.add(linkTo(methodOn(AuthController.class).greeting(name)).withSelfRel());

        return new ResponseEntity<Auth>(greeting, HttpStatus.OK);
    }
}
