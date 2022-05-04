package kea.sem3.jwtdemo.api;


import kea.sem3.jwtdemo.entity.Costumer;
import kea.sem3.jwtdemo.repositories.CostumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/costumers")
public class CostumerController {

    @Autowired
    CostumerRepository costumerRepository;

    @GetMapping
    List<Costumer> getCostumers() {return costumerRepository.findAll();}

    @PostMapping
    Costumer createCostumer (@RequestBody Costumer costumer) {return costumerRepository.save(costumer);}
}
