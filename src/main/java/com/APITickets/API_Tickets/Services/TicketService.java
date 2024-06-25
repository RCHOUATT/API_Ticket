package com.APITickets.API_Tickets.Services;

import com.APITickets.API_Tickets.Module.Ticket;

import java.util.List;

public interface TicketService {


    Ticket CreerTicket(Ticket ticket);

    List<Ticket> AfficherTicket();

    String SupprimerTicket(Long id);

    Ticket UpdateTicket(Long id, Ticket ticket);
    Ticket UpdateTickets(Long id, Ticket ticket);

}