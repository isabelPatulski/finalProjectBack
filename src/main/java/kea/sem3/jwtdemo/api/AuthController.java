package kea.sem3.jwtdemo.api;

import kea.sem3.jwtdemo.dto.UserRequest;
import kea.sem3.jwtdemo.dto.UserResponse;
import kea.sem3.jwtdemo.service.AuthService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/auth")
public class AuthController {

    AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @PostMapping()
    public UserResponse login(@RequestBody UserRequest body) {
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
