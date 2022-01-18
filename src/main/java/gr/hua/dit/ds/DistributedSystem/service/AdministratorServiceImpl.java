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
import org.springframework.stereotype.Service;


import javax.persistence.EntityManager;
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
    public void PrintCitizens(){
        List<Citizen> list = citizenRepository.findAll();
    }

    @Override
    public void PrintMunicipalEmployees(){
        List<ΜunicipalΕmployee> list = municipalEmployeeRepository.findAll();
    }

    @Override
    public void PrintVeterinaries(){
        List<Veterinary> list = veterinaryRepository.findAll();
    }

    @Override
    public void modificationData(Integer AMKA){
        if(AMKA != null){
            Optional<ΜunicipalΕmployee> em =  municipalEmployeeRepository.findById(AMKA.toString());

            if(em != null){

                deleteMunicipalEmployee(AMKA);
                addMunicipalEmployee();
            }

            Optional<Citizen>cit = citizenRepository.findById(AMKA.toString());

            if (cit != null){

                deleteCitizen(AMKA);
                addCitizen();
            }

            Optional<Veterinary> vet = veterinaryRepository.findById(AMKA.toString());

            if (vet != null){

                deleteVeterinary(AMKA);
                addVeterinary();
            }

        }

    }

    @Override
    public void addCitizen(){
        Citizen citizen = new Citizen();
    }

    @Override
    public void addMunicipalEmployee(){
        ΜunicipalΕmployee municipalEmployee = new ΜunicipalΕmployee();
    }

    @Override
    public void addVeterinary(){
        Veterinary veterinary = new Veterinary();
    }

    @Override
    public void deleteCitizen(Integer AMKA){
        if (AMKA != null){
            citizenRepository.deleteById(AMKA.toString());
        }
    }

    @Override
    public void deleteMunicipalEmployee(Integer AMKA){
        if (AMKA != null){
            municipalEmployeeRepository.deleteById(AMKA.toString());
        }
    }

    @Override
    public void deleteVeterinary(Integer AMKA){
        if (AMKA != null){
            veterinaryRepository.deleteById(AMKA.toString());
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
