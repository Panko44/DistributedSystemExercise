package gr.hua.dit.ds.DistributedSystem.controller;

import gr.hua.dit.ds.DistributedSystem.entity.Citizen;
import gr.hua.dit.ds.DistributedSystem.repository.CitizenRepository;
import gr.hua.dit.ds.DistributedSystem.service.CitizenService;
import gr.hua.dit.ds.DistributedSystem.service.CitizenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/CitizenController")
public class CitizenController {

    @Autowired
    private CitizenRepository citizenRepository;


    @GetMapping("/CitizenPage")
    public String citizenPage(@RequestParam(name = "name", required = false, defaultValue = "user") String name, Model model) {
        model.addAttribute("name", name);
        return "citizen_page";
    }

    @GetMapping("/NewPet")
    public String newPet(@RequestParam(name = "name", required = false, defaultValue = "user") String name, Model model) {
        model.addAttribute("name", name);
        return "new_pet";
    }

}
