package com.APITickets.API_Tickets.Repository;

import com.APITickets.API_Tickets.Module.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Notif_repository extends JpaRepository<Notification, Long>{

}
