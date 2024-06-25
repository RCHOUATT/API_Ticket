package com.APITickets.API_Tickets.Services;

import com.APITickets.API_Tickets.Module.Utilisateurs;
import com.APITickets.API_Tickets.Repository.User_repository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
@Data
public class UserServiceImplement implements UserService {

    private final PasswordEncoder passwordEncoder;
    private User_repository UserRepository;

    @Override
    public Utilisateurs CreerUser(Utilisateurs user){
        return UserRepository.save(user);
    };

    @Override
    public List<Utilisateurs> AfficherUser(){
        return  UserRepository.findAll();
    };

    @Override
    public String SupUser(Long id){
        UserRepository.deleteById(id);
        return "Utilisateur " + id + " supprimer avec succes";
    };

    @Override
    public Utilisateurs UpdateUser(Long id, Utilisateurs user){
        return UserRepository.findById(id)
        .map(p-> {
            p.setNom(user.getNom());
            p.setEmail(user.getEmail());
            p.setRole(user.getRole());
            p.setMdp(passwordEncoder.encode(user.getMdp()));
            return UserRepository.save(p);
        }).orElseThrow(()-> new RuntimeException("Nous avons raccontre un probleme lors de la mise a jour de " + id )) ;
    }
}