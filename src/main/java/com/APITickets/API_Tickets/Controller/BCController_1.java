package com.APITickets.API_Tickets.Controller;

import com.APITickets.API_Tickets.Module.BaseDeConnaissance;
import com.APITickets.API_Tickets.Services.BaseConService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("BDCons")
public class BCController_1 {
  private BaseConService baseConService;


    @GetMapping("/Afficher")
    public List<BaseDeConnaissance> Afficher() {
        return baseConService.AfficherBC();
    }
}
