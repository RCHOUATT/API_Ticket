package com.APITickets.API_Tickets.Controller;


import com.APITickets.API_Tickets.Module.Ticket;
import com.APITickets.API_Tickets.Services.TicketServiceImplement;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("tickets")
@Tag(name ="ControllerTicket", description = "Le système de tickets permet aux formateurs de prioriser les demandes en fonction de leur urgence et de leur importance, garantissant ainsi une gestion du temps plus efficace.\n" +
        "\n" +
        "Il permet aux apprenants de recevoir des conseils et une assistance adaptés à leurs besoins spécifiques.\n" +
        "\n" +
        "Il permet egalement de garder une trace des interactions entre les formateurs et les apprenants pour mieux suivre l'évolution de chaque participant.\n")

public class TicketController_1 {

    private TicketServiceImplement TicketService;
    @Operation(description = "Ce point d'entré permet d'affciher des tickets. Il est destiner aux apprenants.")
    @GetMapping("/Afficher")
    public List<Ticket> Afficher(){
        return TicketService.AfficherTicket();
    }

    @Operation(description = "Ce point d'entré permet de mettre à jour un ticket. Il est destiner aux apprenants.")
    @PutMapping("/update/{id}")
    public Ticket update(@PathVariable Long id, @RequestBody Ticket ticket){
        return TicketService.UpdateTickets(id, ticket);
    }

}
