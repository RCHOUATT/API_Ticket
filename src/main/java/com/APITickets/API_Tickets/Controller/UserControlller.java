package com.APITickets.API_Tickets.Controller;


import com.APITickets.API_Tickets.Module.Utilisateurs;
import com.APITickets.API_Tickets.Services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("User")
@Tag(name ="Userontroller", description = "Les utilisateurs sont ceux qui utilisent le systemes. C'est à dire les acteurs." +
        "Ce sont les AMINS, les FORMATEURS, les APPRENANTS")

public class UserControlller {

    private final PasswordEncoder passwordEncoder;
    private UserService userService;

    @Operation(description = "Ce point d'entré permet d'ajouter des utilisateurs")
    @PostMapping("/Ajout")
    public Utilisateurs Creer(@RequestBody Utilisateurs user) {
        user.setMdp(passwordEncoder.encode(user.getMdp()));
        return userService.CreerUser(user);
    }

    @Operation(description = "Ce point d'entré permet d'affciher des utilisateurs")
    @GetMapping("/Afficher")
    public List<Utilisateurs> Afficher() {
        return userService.AfficherUser();
    }

    @Operation(description = "Ce point d'entré permet de supprimer un utilisateur")
    @DeleteMapping("/Supprimer/{id}")
    public String supprimer(@PathVariable Long id) {
        return userService.SupUser(id);
    }

    @Operation(description = "Ce point d'entré permet de mettre à jour un utilisateur")
    @PutMapping("/update/{id}")
    public Utilisateurs updateUser(@PathVariable Long id, @RequestBody Utilisateurs user) {
        user.setMdp(passwordEncoder.encode(user.getMdp()));
        return userService.UpdateUser(id, user);
    }
}
