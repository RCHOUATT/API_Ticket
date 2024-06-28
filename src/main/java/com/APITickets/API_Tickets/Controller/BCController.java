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
@RequestMapping("BDCon")
@Tag(name ="BCController", description = "Une base de connaissance " +
        "regroupe des connaissances spécifiques à un domaine spécialisé donné, sous une forme. " +
        "Ce sont des reponses aux questions frequentes posées par les apprenants. C'est le formateur qui repond à ces questions.")
public class BCController {
    private BaseConService baseConService;

    @Operation(description = "Ce point d'entré permet d'ajouter des données à la base de connaissance")
    @PostMapping("/Ajout")
    public BaseDeConnaissance Creer(@RequestBody BaseDeConnaissance BaseDeConn){
        return baseConService.creer(BaseDeConn);
    }

    @Operation(description = "Ce point d'entré permet d'afficher les données de la base de connaissance")
    @GetMapping("/Afficher")
    public List<BaseDeConnaissance> Afficher() {
        return baseConService.AfficherBC();
    }

    @Operation(description = "Ce point d'entré permet de supprimer une donnée de la base de connaissance")
    @DeleteMapping("/Supprimer/{id}")
    public String supprimer(@PathVariable Long id) {
        return baseConService.SuppBC(id);
    }

    @Operation(description = "Ce point d'entré permet de mettre à jour une donnée de la base de connaissance")
    @PutMapping("/update/{id}")
    public BaseDeConnaissance update(@PathVariable Long id, @RequestBody BaseDeConnaissance BaseDeConn) {
        return baseConService.UpdateBC(id, BaseDeConn);
    }
}