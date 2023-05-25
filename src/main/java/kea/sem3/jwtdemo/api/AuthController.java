package kea.sem3.jwtdemo.api;

import kea.sem3.jwtdemo.dto.CustomerRequest;
import kea.sem3.jwtdemo.dto.CustomerResponse;
import kea.sem3.jwtdemo.entity.Customer;
import kea.sem3.jwtdemo.repositories.CustomerRepository;
import kea.sem3.jwtdemo.service.AuthService;
import kea.sem3.jwtdemo.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/auth")
public class AuthController {

    AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @PostMapping()
    public CustomerResponse loginCustomer(@RequestBody CustomerRequest body) {
        System.out.println(body);
        return authService.login(body.getEmail(), body.getPassword());
    }

    /*@PostMapping("/logout")
    public Customer logOut(@Valid @RequestBody CustomerRequest customer) {
        List<Customer> customers = customerRepository.findAll();
        for (Customer other : customers) {
            if (other.equals(customer)) {
                customer.setLoggedIn(false);
                customerRepository.save(customer);
                return customer;
            }
        }
        return customer;
    }*/
    }
