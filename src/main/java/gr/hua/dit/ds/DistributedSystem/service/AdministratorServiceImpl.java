package gr.hua.dit.ds.DistributedSystem.service;

import gr.hua.dit.ds.DistributedSystem.entity.Administrator;
import gr.hua.dit.ds.DistributedSystem.entity.Citizen;
import gr.hua.dit.ds.DistributedSystem.entity.Veterinary;
import gr.hua.dit.ds.DistributedSystem.entity.ΜunicipalΕmployee;
import gr.hua.dit.ds.DistributedSystem.repository.AdministratorRepository;
import gr.hua.dit.ds.DistributedSystem.repository.CitizenRepository;
import gr.hua.dit.ds.DistributedSystem.repository.MunicipalEmployeeRepository;
import gr.hua.dit.ds.DistributedSystem.repository.VeterinaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public abstract class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private AdministratorRepository administratorRepository;
    @Autowired
    private CitizenRepository citizenRepository;
    @Autowired
    private MunicipalEmployeeRepository municipalEmployeeRepository;
    @Autowired
    private VeterinaryRepository veterinaryRepository;

    @Autowired
    public AdministratorServiceImpl(AdministratorRepository admin ){

        administratorRepository = admin ;
    }

    @Override
    @Transactional
    public List<Citizen> ListCitizens(){

        List<Citizen> list = citizenRepository.findAll();
        return list;
    }

    @Override
    @Transactional
    public List<ΜunicipalΕmployee> ListMunicipalEmployees(){

        List<ΜunicipalΕmployee> list = municipalEmployeeRepository.findAll();
        return list;
    }

    @Override
    @Transactional
    public List<Veterinary> ListVeterinaries(){

        List<Veterinary> list = veterinaryRepository.findAll();
        return list;
    }

    @Override
    @Transactional
    public ResponseEntity<Object> modificationMunicipalEmployee(@RequestBody ΜunicipalΕmployee municipalEmployee, @PathVariable Integer AMKA){
        String amka= AMKA.toString();
        Optional<ΜunicipalΕmployee> municipalEmployeeOptional = municipalEmployeeRepository.findById(amka);
        if(!municipalEmployeeOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        municipalEmployee.setAMKA(AMKA);
        municipalEmployeeRepository.save(municipalEmployee);
        return ResponseEntity.noContent().build();
    }

    @Override
    @Transactional
    public ResponseEntity<Object> modificationVeterinary(@RequestBody Veterinary veterinary,Integer AMKA){
        String amka= AMKA.toString();
        Optional<Veterinary> veterinaryOptional = veterinaryRepository.findById(amka);
        if(!veterinaryOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        veterinary.setAMKA(AMKA);
        veterinaryRepository.save(veterinary);
        return ResponseEntity.noContent().build();
    }

    @Override
    @Transactional
    public ResponseEntity<Object> modificationCitizen(@RequestBody Citizen citizen, Integer AMKA){
        String amka= AMKA.toString();
        Optional<Citizen> citizenOptional = citizenRepository.findById(amka);
        if(!citizenOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        citizen.setAMKA(AMKA);
        citizenRepository.save(citizen);
        return ResponseEntity.noContent().build();
    }

    @Override
    @Transactional
    public ResponseEntity<Object> addCitizen(@RequestBody Citizen citizen){
        Citizen savedCitizen = citizenRepository.save(citizen);
        System.out.println("Citizen amka"+savedCitizen.getAMKA());

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{amkaCitizen}").buildAndExpand(savedCitizen.getAMKA()).toUri();

        return ResponseEntity.created(location).build();
    }

    @Override
    @Transactional
    public ResponseEntity<Object> addMunicipalEmployee(@RequestBody ΜunicipalΕmployee municipalEmployee ){
        ΜunicipalΕmployee savedΜunicipalΕmployee = municipalEmployeeRepository.save(municipalEmployee);
        System.out.println("ΜunicipalΕmployee amka"+savedΜunicipalΕmployee.getAMKA());

        URI location =ServletUriComponentsBuilder.fromCurrentRequest().path("/{amkaΜunicipalΕmployee}").buildAndExpand(savedΜunicipalΕmployee.getAMKA()).toUri();
        return ResponseEntity.created(location).build();
    }

    @Override
    @Transactional
    public ResponseEntity<Object> addVeterinary(@RequestBody Veterinary veterinary){
        Veterinary savedVeterinary = veterinaryRepository.save(veterinary);
        System.out.println("Veterinary amka"+savedVeterinary.getAMKA());

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{amkaVeterinary}").buildAndExpand(savedVeterinary.getAMKA()).toUri();
        return ResponseEntity.created(location).build();
    }

    @Override
    @Transactional
    public void deleteCitizen(Integer AMKA){
        if (AMKA != null){
            String amka= AMKA.toString();
            citizenRepository.deleteById(amka);
        }
    }

    @Override
    @Transactional
    public void deleteMunicipalEmployee(Integer AMKA){
        if (AMKA != null){
            String amka= AMKA.toString();
            municipalEmployeeRepository.deleteById(amka);
        }
    }

    @Override
    @Transactional
    public void deleteVeterinary(Integer AMKA){
        if (AMKA != null){
            String amka= AMKA.toString();
            veterinaryRepository.deleteById(amka);
        }
    }

    @Override
    @Transactional
    public boolean logIn(String email , String password){
        if(email != null){
            Optional<Administrator> admin = administratorRepository.findById(email);
            if(admin != null){
                if(admin.get().getPassword() == password){
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }
}
