package com.APITickets.API_Tickets.Security;

import com.APITickets.API_Tickets.Module.Utilisateurs;
import com.APITickets.API_Tickets.Repository.User_repository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class DetailServiceImpl implements UserDetailsService {

    private User_repository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("Hello");
        Utilisateurs myuser = userRepository.findByEmail(email);
        System.out.println("Hello1");
        if(myuser == null) throw new UsernameNotFoundException("L'utilisateur n'a pas été trouvé");
        System.out.println("Hello3");
        System.out.println(myuser.getRole());
        System.out.println(myuser.getMdp());
        System.out.println(myuser.getEmail());

        return User.
                withUsername(myuser.getEmail()).
                password(myuser.getMdp()).
                roles(String.valueOf(myuser.getRole())).build();
    }
}
