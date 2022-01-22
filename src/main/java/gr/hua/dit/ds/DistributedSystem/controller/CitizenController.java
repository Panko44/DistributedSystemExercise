package gr.hua.dit.ds.DistributedSystem.controller;

import gr.hua.dit.ds.DistributedSystem.entity.Citizen;
import gr.hua.dit.ds.DistributedSystem.repository.CitizenRepository;
import gr.hua.dit.ds.DistributedSystem.service.CitizenService;
import gr.hua.dit.ds.DistributedSystem.service.CitizenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("/CitizenController")
public class CitizenController {

    @Autowired
    private CitizenRepository citizenRepository;

//    @GetMapping("/list")
//    public String listCustomers(Model model) {
//        // get customers from dao
//        List<Citizen> citizenList = citizenRepository.findAll();
//
//        // add the customers to the model
//        model.addAttribute("customers", citizenList);
//
//        return "list-customers";
//    }

    @GetMapping(path = "citizens")
    List<Citizen> retrieveAllCitizens() {
        return citizenRepository.findAll();
    }

}
