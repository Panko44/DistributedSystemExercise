package gr.hua.dit.ds.DistributedSystem.controller;

import gr.hua.dit.ds.DistributedSystem.entity.Administrator;
import gr.hua.dit.ds.DistributedSystem.entity.Citizen;
import gr.hua.dit.ds.DistributedSystem.entity.Veterinary;
import gr.hua.dit.ds.DistributedSystem.repository.AdministratorRepository;
import gr.hua.dit.ds.DistributedSystem.repository.CitizenRepository;
import gr.hua.dit.ds.DistributedSystem.repository.MunicipalEmployeeRepository;
import gr.hua.dit.ds.DistributedSystem.repository.VeterinaryRepository;
import gr.hua.dit.ds.DistributedSystem.service.AdministratorService;
import gr.hua.dit.ds.DistributedSystem.service.AdministratorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/AdministratorController")
public class AdministatorController {

    @Autowired
    private AdministratorRepository administratorRepository;
    @Autowired
    private CitizenRepository citizenRepository;
    @Autowired
    private MunicipalEmployeeRepository municipalEmployeeRepository;
    @Autowired
    private VeterinaryRepository veterinaryRepository;

    @GetMapping("/AdministratorPage")
    public String administratorPage(@RequestParam(name = "name", required = false, defaultValue = "user") String name, Model model) {
        model.addAttribute("name", name);
        return "administrator_page";
    }

    @GetMapping("/AdministratorDelete")
    public String administratorDelete(@RequestParam(name = "name", required = false, defaultValue = "user") String name, Model model) {
        model.addAttribute("name", name);
        return "Admin_delete_page";
    }

    @GetMapping("/AdministratorShowList")
    public String administratorShowList(@RequestParam(name = "name", required = false, defaultValue = "user") String name, Model model) {
        model.addAttribute("name", name);
        return "Admin_show_list";
    }

    @GetMapping("/AdministratorModificationPage")
    public String administratorModificationPage(@RequestParam(name = "name", required = false, defaultValue = "user") String name, Model model) {
        model.addAttribute("name", name);
        return "Admin_modification_page";
    }

    @GetMapping("/AdministratorAddUser")
    public String administratorAddUser(@RequestParam(name = "name", required = false, defaultValue = "user") String name, Model model) {
        model.addAttribute("name", name);
        return "admin_add_user";
    }

    @ResponseBody
    @GetMapping("/ShowCitizens")
    List<Citizen> reretrieveAllCitizens() {
        return citizenRepository.findAll();
    }

    @ResponseBody
    @GetMapping("/ShowMunicipalEmployees")
    List retrieveAllMunicipalEmployees(){
        return municipalEmployeeRepository.findAll();
    }

    @ResponseBody
    @GetMapping("/ShowVeterinaries")
    List<Veterinary> retrieveAllVeterinaries() {
        return veterinaryRepository.findAll();
    }

}
