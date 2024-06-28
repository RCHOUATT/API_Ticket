package com.APITickets.API_Tickets.Controller;


import com.APITickets.API_Tickets.Module.Utilisateurs;
import com.APITickets.API_Tickets.Services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@RestController
@RequestMapping("Users")
@Tag(name ="Userontroller", description = "Les utilisateurs sont ceux qui utilisent le systemes. C'est à dire les acteurs." +
        "Ce sont les AMINS, les FORMATEURS, les APPRENANTS")

public class UserControlller_1 {

    private final PasswordEncoder passwordEncoder;
    private UserService userService;

    @Operation(description = "Ce point d'entré permet de mettre à jour un utilisateur")
    @PutMapping("/update/{id}")
    public Utilisateurs updateUser(@PathVariable Long id, @RequestBody Utilisateurs user) {
        user.setMdp(passwordEncoder.encode(user.getMdp()));
        return userService.UpdateUser(id, user);
    }
}
