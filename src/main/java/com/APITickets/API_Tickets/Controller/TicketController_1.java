package com.APITickets.API_Tickets.Controller;


import com.APITickets.API_Tickets.Module.Ticket;
import com.APITickets.API_Tickets.Services.TicketServiceImplement;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("tickets")
public class TicketController_1 {

    private TicketServiceImplement TicketService;

    @GetMapping("/Afficher")
    public List<Ticket> Afficher(){
        return TicketService.AfficherTicket();
    }

    @PutMapping("/update/{id}")
    public Ticket update(@PathVariable Long id, @RequestBody Ticket ticket){
        return TicketService.UpdateTickets(id, ticket);
    }

}
