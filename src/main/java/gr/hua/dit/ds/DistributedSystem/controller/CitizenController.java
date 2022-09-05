package gr.hua.dit.ds.DistributedSystem.controller;
import gr.hua.dit.ds.DistributedSystem.entity.Pet;
import gr.hua.dit.ds.DistributedSystem.repository.PetRepository;
import gr.hua.dit.ds.DistributedSystem.entity.Citizen;
import gr.hua.dit.ds.DistributedSystem.entity.Veterinary;
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

    @Autowired
    private PetRepository petRepository;


    @GetMapping("/CitizenPage")
    public String citizenPage(@RequestParam(name = "name", required = false, defaultValue = "user") String name, Model model) {
        model.addAttribute("name", name);
        return "citizen_page";
    }

    @GetMapping("/NewPetForm")
    public String NewPetForm(Pet pet, Model model){
        return "new_pet";
    }

    @RequestMapping(value = "/NewPetSave", method = { RequestMethod.GET, RequestMethod.POST })
    public String NewPetSave(Pet pet, Model model){
        model.addAttribute("pet", pet);
        Pet savedPet = petRepository.save(pet);
        System.out.println("Citizen amka"+savedPet.getNumberOfMicrochip());
        return "redirect:/CitizenController/CitizenPage";
    }

}
