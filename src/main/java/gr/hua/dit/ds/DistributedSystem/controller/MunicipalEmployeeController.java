package gr.hua.dit.ds.DistributedSystem.controller;

import gr.hua.dit.ds.DistributedSystem.entity.Citizen;
import gr.hua.dit.ds.DistributedSystem.entity.MunicipalEmployee;
import gr.hua.dit.ds.DistributedSystem.repository.CitizenRepository;
import gr.hua.dit.ds.DistributedSystem.repository.MunicipalEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Controller
@RequestMapping("/MunicipalEmployeeController")
public class MunicipalEmployeeController {

    @Autowired
    private MunicipalEmployeeRepository municipalEmployeeRepository;

    @GetMapping("/MunicipalEmployeePage")
    public String municipalEmployeePage(@RequestParam(name = "name", required = false, defaultValue = "user") String name, Model model) {
        model.addAttribute("name", name);
        return "municipalEmployee_page";
    }

    @GetMapping("/ShowLostPets")
    public String showLostPets(Model model){
        MunicipalEmployee m = new MunicipalEmployee();
        List listLostPet = m.getLostPets();
        model.addAttribute("listLostPet", listLostPet);
        return "show_lost_pets";
    }

}
