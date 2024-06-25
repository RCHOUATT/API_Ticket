package com.APITickets.API_Tickets.Services;

import com.APITickets.API_Tickets.Module.Utilisateurs;

import java.util.List;

public interface UserService {

    Utilisateurs CreerUser(Utilisateurs user);

    List<Utilisateurs> AfficherUser();

    String SupUser(Long id);

    Utilisateurs UpdateUser(Long id, Utilisateurs user);

}