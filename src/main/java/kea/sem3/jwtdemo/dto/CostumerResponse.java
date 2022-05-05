package kea.sem3.jwtdemo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import kea.sem3.jwtdemo.entity.Costumer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CostumerResponse {
    int id;

    String username;
    String email;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss",shape = JsonFormat.Shape.STRING)
    LocalDateTime created;

    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss",shape = JsonFormat.Shape.STRING)
    LocalDateTime updated;

    public CostumerResponse(Costumer costumer) {
        this.username = costumer.getUsername();
        this.email = costumer.getEmail();

    }

    public static List<kea.sem3.jwtdemo.dto.CostumerResponse> getCostumersFromEntities(List<Costumer> costumers){
        return costumers.stream().map(costumer-> new kea.sem3.jwtdemo.dto.CostumerResponse(costumer)).collect(Collectors.toList());
    }
}

