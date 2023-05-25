package kea.sem3.jwtdemo.service;

import kea.sem3.jwtdemo.dto.CustomerResponse;
import kea.sem3.jwtdemo.entity.Customer;
import kea.sem3.jwtdemo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class AuthService {

    CustomerRepository customerRepository;
    Customer customer;

    public AuthService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public CustomerResponse login(String email , String password) {
        customer = customerRepository.findByEmail(email);
        if (customer == null) {
            return null; //User not found, no reason to check further
        }
        customer.setLoggedIn(false); //makes sure that the user is logged out
        if (!customer.getPassword().equals(password)) {
            return null; //Password from db does not match password given by user
        }
        customer.setLoggedIn(true);
        return new CustomerResponse(customer);
    }

    public boolean notLoggedIn(HttpSession session) {
        return session.getAttribute("customer") == null;
    }

}

