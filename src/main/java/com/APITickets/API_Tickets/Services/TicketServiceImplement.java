package com.APITickets.API_Tickets.Services;

import com.APITickets.API_Tickets.Module.Notification;
import com.APITickets.API_Tickets.Module.Ticket;
import com.APITickets.API_Tickets.Repository.Ticket_repository;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;



import java.util.List;

@AllArgsConstructor
@Service
@Data
public class TicketServiceImplement implements TicketService {

    private Ticket_repository ticketRepository;
    private NotifService notifService;


    @Override
    public Ticket CreerTicket(Ticket ticket) {
        Notification notif = new Notification();
        notif.setSubject("Nouveau Ticket");
        notif.setDest_email(ticket.getCible());
        try {
            notifService.sendEmail(notif);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> AfficherTicket() {
        return ticketRepository.findAll();
    }

    @Override
    public String SupprimerTicket(Long id) {
        ticketRepository.deleteById(id);
        return "Ticket " + id + " Ticket avec succès";
    }

    @Override
    public Ticket UpdateTicket(Long id, Ticket ticket) {
        return ticketRepository.findById(id)
                    .map(p -> {
                        p.setTitre(ticket.getTitre());
                        p.setDescription(ticket.getDescription());
                        p.setStatus(ticket.getStatus());
                        return ticketRepository.save(p);
                    }).orElseThrow(() -> new RuntimeException("Ticket " + id + " non trouvé" ));
    }

    @Override
    public Ticket UpdateTickets(Long id, Ticket ticket) {
        return ticketRepository.findById(id)
                .map(p -> {
                    p.setReponse(ticket.getReponse());
                    return ticketRepository.save(p);
                }).orElseThrow(() -> new RuntimeException("Ticket " + id + " non trouvé" ));
    }
}