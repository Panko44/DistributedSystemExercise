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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import javax.persistence.EntityManager;
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
    public List<Citizen> ListCitizens(){

        List<Citizen> list = citizenRepository.findAll();
        return list;
    }

    @Override
    public List<ΜunicipalΕmployee> ListMunicipalEmployees(){

        List<ΜunicipalΕmployee> list = municipalEmployeeRepository.findAll();
        return list;
    }

    @Override
    public List<Veterinary> ListVeterinaries(){

        List<Veterinary> list = veterinaryRepository.findAll();
        return list;
    }

    // fix later modification
    @Override
    public void modificationData(String AMKA){
        if(AMKA != null){
            Optional<ΜunicipalΕmployee> em =  municipalEmployeeRepository.findById(AMKA.toString());

            if(em != null){

                deleteMunicipalEmployee(AMKA);
                //addMunicipalEmployee();
            }

            Optional<Citizen>cit = citizenRepository.findById(AMKA.toString());

            if (cit != null){

                deleteCitizen(AMKA);
                //addCitizen();
            }

            Optional<Veterinary> vet = veterinaryRepository.findById(AMKA.toString());

            if (vet != null){

                deleteVeterinary(AMKA);
                //addVeterinary();
            }

        }

    }

    @Override
    public ResponseEntity<Object> addCitizen(@RequestBody Citizen citizen){
        Citizen savedCitizen = citizenRepository.save(citizen);
        System.out.println("Citizen amka"+savedCitizen.getAMKA());

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{amkaCitizen}").buildAndExpand(savedCitizen.getAMKA()).toUri();

        return ResponseEntity.created(location).build();
    }

    @Override
    public ResponseEntity<Object> addMunicipalEmployee(@RequestBody ΜunicipalΕmployee municipalEmployee ){
        ΜunicipalΕmployee savedΜunicipalΕmployee = municipalEmployeeRepository.save(municipalEmployee);
        System.out.println("ΜunicipalΕmployee amka"+savedΜunicipalΕmployee.getAMKA());

        URI location =ServletUriComponentsBuilder.fromCurrentRequest().path("/{amkaΜunicipalΕmployee}").buildAndExpand(savedΜunicipalΕmployee.getAMKA()).toUri();
        return ResponseEntity.created(location).build();
    }

    @Override
    public ResponseEntity<Object> addVeterinary(@RequestBody Veterinary veterinary){
        Veterinary savedVeterinary = veterinaryRepository.save(veterinary);
        System.out.println("Veterinary amka"+savedVeterinary.getAMKA());

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{amkaVeterinary}").buildAndExpand(savedVeterinary.getAMKA()).toUri();
        return ResponseEntity.created(location).build();
    }

    @Override
    public void deleteCitizen(String AMKA){
        if (AMKA != null){
            citizenRepository.deleteById(AMKA);
        }
    }

    @Override
    public void deleteMunicipalEmployee(String AMKA){
        if (AMKA != null){
            municipalEmployeeRepository.deleteById(AMKA);
        }
    }

    @Override
    public void deleteVeterinary(String AMKA){
        if (AMKA != null){
            veterinaryRepository.deleteById(AMKA);
        }
    }

    @Override
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
