package kea.sem3.jwtdemo.service;

import kea.sem3.jwtdemo.dto.CostumerRequest;
import kea.sem3.jwtdemo.dto.CostumerResponse;
import kea.sem3.jwtdemo.entity.Costumer;
import kea.sem3.jwtdemo.error.Client4xxException;
import kea.sem3.jwtdemo.repositories.CostumerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CostumerService {
    CostumerRepository costumerRepository;

    public CostumerService(CostumerRepository costumerRepository) {
        this.costumerRepository = costumerRepository;
    }

    public List<CostumerResponse> getCostumers(){
        List<Costumer> costumers =  costumerRepository.findAll();
        return CostumerResponse.getCostumersFromEntities(costumers);
    }
    public CostumerResponse getCostumer(int id) throws Exception {
        Costumer costumer = costumerRepository.findById(id).orElseThrow(()->new Client4xxException("No costumer with this id exists"));
        return new CostumerResponse(costumer);
    }
    public CostumerResponse addCostumer(CostumerRequest body){
        Costumer newCostumer = costumerRepository.save(new Costumer(body));
        return new CostumerResponse(newCostumer);
    }
    public CostumerResponse editCostumer(CostumerRequest costumerToEdit, int costumerId){
        Costumer costumer = costumerRepository.findById(costumerId).orElseThrow(()-> new Client4xxException("No costumer with provided ID found"));
        costumer.setUsername(costumerToEdit.getUsername());
        costumer.setEmail(costumerToEdit.getEmail());
        return new CostumerResponse(costumerRepository.save(costumer));
    }

    //PATCH method for Username
    public void updateUsername(int costumerId, String newUsername){
        Costumer costumer = costumerRepository.findById(costumerId).orElseThrow(()-> new Client4xxException("No costumer with provided ID found"));
        costumer.setUsername(newUsername);
        costumerRepository.save(costumer);
    }

    //PATCH for Email
    public void updateEmail(int costumerId,String newEmail){
        Costumer costumer = costumerRepository.findById(costumerId).orElseThrow(()-> new Client4xxException("No costumer with provided ID found"));
        costumer.setEmail(newEmail);
        costumerRepository.save(costumer);
    }

    public void deleteCostumer(int costumerId) {
        costumerRepository.deleteById(costumerId);
    }
}

