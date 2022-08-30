package gr.hua.dit.ds.DistributedSystem.controller;

import gr.hua.dit.ds.DistributedSystem.entity.Citizen;
import gr.hua.dit.ds.DistributedSystem.entity.Veterinary;
import gr.hua.dit.ds.DistributedSystem.repository.AdministratorRepository;
import gr.hua.dit.ds.DistributedSystem.repository.CitizenRepository;
import gr.hua.dit.ds.DistributedSystem.repository.MunicipalEmployeeRepository;
import gr.hua.dit.ds.DistributedSystem.repository.VeterinaryRepository;
import gr.hua.dit.ds.DistributedSystem.service.AdministratorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
@RequestMapping("/AdministratorController")
public class AdministratorController {

    @Autowired
    private AdministratorRepository administratorRepository;
    @Autowired
    private CitizenRepository citizenRepository;
    @Autowired
    private MunicipalEmployeeRepository municipalEmployeeRepository;
    @Autowired
    private VeterinaryRepository veterinaryRepository;

    private AdministratorServiceImpl administratorServiceImpl;

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

    @RequestMapping(value = "/AdministratorDeletePage/Citizen/{AMKA}", method = { RequestMethod.GET, RequestMethod.POST })
    public String administratorDeleteCitizen(@PathVariable(value = "ΑΜΚΑ") Integer AMKA) {
        System.out.println("Citizen1 amka" +AMKA);
        System.out.println("Citizen2 amka" +AMKA);
        administratorServiceImpl.deleteCitizen(AMKA);
        System.out.println("Citizen3 amka" +AMKA);
        return "redirect:/AdministratorController/AdministratorPage";
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




//    @ResponseBody
//    @GetMapping("/ShowCitizens")
//    List<Citizen> retrieveAllCitizens() {
//        return citizenRepository.findAll();
//    }


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


    @RequestMapping(value = "/AdministratorAddUser/Citizen", method = { RequestMethod.GET, RequestMethod.POST })
    public String addCitizen(Citizen citizen, Model model){
        model.addAttribute("citizen", citizen);
        Citizen savedCitizen = citizenRepository.save(citizen);

        System.out.println("Citizen amka"+savedCitizen.getAMKA());

        //URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{amkaCitizen}").buildAndExpand(savedCitizen.getAMKA()).toUri();

        //return ResponseEntity.created(location).build();
        return "redirect:/AdministratorController/AdministratorPage";
    }

    @RequestMapping(value = "/AdministratorModificationPage/Citizen/{AMKA}", method = { RequestMethod.GET, RequestMethod.POST })
    public String showEditForm(@PathVariable("AMKA") Integer AMKA, Model model){
        //String amka= AMKA.toString();
        Citizen citizen = administratorServiceImpl.get(AMKA);

        model.addAttribute("citizen", citizen);
        return "admin_add_user";
    }

    @GetMapping("/ShowCitizens")
    public String showCitizenList(Model model){
        List<Citizen> listCitizen = citizenRepository.findAll();
        model.addAttribute("listCitizen", listCitizen);
        return "Admin_show_list";
    }

//    @ResponseBody
//    @PostMapping("/AdministratorAddUser/Citizen")
//    public ResponseEntity<Citizen> addCitizen(@RequestBody Citizen citizen){
//        Citizen savedCitizen = citizenRepository.save(citizen);
//        System.out.println("Citizen amka"+savedCitizen.getAMKA());
//
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{amkaCitizen}").buildAndExpand(savedCitizen.getAMKA()).toUri();
//
//        return ResponseEntity.created(location).build();
//    }


//    @GetMapping("/users")
//    public String listUsers(Model model) {
//        List<Citizen> listUsers = administratorServiceImpl.ListCitizens();
//        model.addAttribute("listUsers", listUsers);
//
//        return "citizen";
//    }


}
