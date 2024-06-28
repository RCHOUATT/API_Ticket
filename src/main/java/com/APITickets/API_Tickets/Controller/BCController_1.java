package com.APITickets.API_Tickets.Controller;

import com.APITickets.API_Tickets.Module.BaseDeConnaissance;
import com.APITickets.API_Tickets.Services.BaseConService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("BDCons")
@Tag(name ="BCController", description = "Une base de connaissance " +
        "regroupe des connaissances spécifiques à un domaine spécialisé donné, sous une forme. " +
        "Ce sont des reponses aux questions frequentes posées par les apprenants. C'est le formateur qui repond à ces questions.")
public class BCController_1 {
  private BaseConService baseConService;

    @Operation(description = "Ce point d'entré permet d'afficher des données à la base de connaissance." +
            "Il est pour les apprenants.")
    @GetMapping("/Afficher")
    public List<BaseDeConnaissance> Afficher() {
        return baseConService.AfficherBC();
    }
}
