package com.APITickets.API_Tickets.Controller;


import com.APITickets.API_Tickets.Module.Utilisateurs;
import com.APITickets.API_Tickets.Services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@RestController
@RequestMapping("Users")
public class UserControlller_1 {


    private final PasswordEncoder passwordEncoder;
    private UserService userService;


    @DeleteMapping("/Supprimer/{id}")
    public String supprimer(@PathVariable Long id) {
        return userService.SupUser(id);
    }

    @PutMapping("/update/{id}")
    public Utilisateurs updateUser(@PathVariable Long id, @RequestBody Utilisateurs user) {
        return userService.UpdateUser(id, user);
    }
}
