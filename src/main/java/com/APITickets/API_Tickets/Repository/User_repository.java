package com.APITickets.API_Tickets.Repository;

import com.APITickets.API_Tickets.Module.Utilisateurs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface User_repository extends JpaRepository<Utilisateurs, Long>{

    Utilisateurs findByEmail(String email);
}
