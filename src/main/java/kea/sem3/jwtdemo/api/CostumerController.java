package kea.sem3.jwtdemo.api;


import kea.sem3.jwtdemo.dto.CostumerRequest;
import kea.sem3.jwtdemo.dto.CostumerResponse;
import kea.sem3.jwtdemo.dto.MovieRequest;
import kea.sem3.jwtdemo.dto.MovieResponse;
import kea.sem3.jwtdemo.entity.Costumer;
import kea.sem3.jwtdemo.repositories.CostumerRepository;
import kea.sem3.jwtdemo.service.CostumerService;
import kea.sem3.jwtdemo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/costumers")
public class CostumerController {

    CostumerService costumerService;
    @Autowired
    CostumerRepository costumerRepository;

    public CostumerController(CostumerService costumerService) {
        this.costumerService = costumerService;
    }

    @GetMapping
    List<Costumer> getCostumers() {return costumerRepository.findAll();}

    @PostMapping
    Costumer createCostumer (@RequestBody Costumer costumer) {return costumerRepository.save(costumer);}

    @GetMapping("/{id}")
    public CostumerResponse getCostumer(@PathVariable int id) throws Exception {
        return costumerService.getCostumer(id);
    }

    @PostMapping
    public CostumerResponse addCostumer(@RequestBody CostumerRequest body) { return costumerService.addCostumer(body);}

    @PutMapping("/{id}")
    public CostumerResponse editCostumer(@RequestBody CostumerRequest body, @PathVariable int id){
        return costumerService.editCostumer(body,id);
    }

    //Hvad skal der stå her? Eller hvorfor står der newprice?
    @PatchMapping ("/{id}/{newprice}")
    public void editUsername(@PathVariable int id,@PathVariable String newUsername) throws Exception {
        costumerService.updateUsername(id,newUsername);
    }

    @PatchMapping ("/{id}/{newprice}")
    public void editEmail(@PathVariable int id,@PathVariable String newEmail) throws Exception {
        costumerService.updateEmail(id,newEmail);
    }

    @DeleteMapping("/{id}")
    public void deleteCostumer(@PathVariable int id){}
}



