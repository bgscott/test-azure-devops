package hello.controllers;

import hello.model.Address;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressRestController {


    @GetMapping("/address")
    public Address address() {
        Address address = new Address();
        address.setAddress("112 Shoemaker lane");
        address.setCity("Vandalia");
        address.setState("Ohio");
        address.setCountry("US");

        return address;
    }
}
