package kea.sem3.jwtdemo.api;


import kea.sem3.jwtdemo.dto.CustomerRequest;
import kea.sem3.jwtdemo.dto.CustomerResponse;
import kea.sem3.jwtdemo.entity.Customer;
import kea.sem3.jwtdemo.repositories.CustomerRepository;
import kea.sem3.jwtdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/customer")
public class CustomerController {

    CustomerService customerService;
    CustomerRepository customerRepository;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    List<Customer> getCustomers() {return customerRepository.findAll();}


    @GetMapping("/{email}")
    public CustomerResponse getCustomer(@PathVariable String email) throws Exception {
        return customerService.getCustomer(email);
    }


    @PostMapping
    public CustomerResponse addCustomer(@RequestBody CustomerRequest body) {
        System.out.println("Received customer request: " + body);
        return customerService.addCustomer(body);}

    @PutMapping("/{id}")
    public CustomerResponse editCustomer(@RequestBody CustomerRequest body, @PathVariable int id){
        return customerService.editCustomer(body,id);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable int id){}
}



