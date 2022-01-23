package gr.hua.dit.ds.DistributedSystem.service;

import gr.hua.dit.ds.DistributedSystem.entity.Administrator;
import gr.hua.dit.ds.DistributedSystem.entity.Pet;
import gr.hua.dit.ds.DistributedSystem.entity.ΜunicipalΕmployee;
import gr.hua.dit.ds.DistributedSystem.repository.MunicipalEmployeeRepository;
import gr.hua.dit.ds.DistributedSystem.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class MunicipalEmployeeServiceImpl implements MunicipalEmployeeService{

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private MunicipalEmployeeRepository municipalEmployeeRepository;

    @Autowired
    private PetRepository petRepository;

    @Override
    @Transactional
    public boolean logIn(String email, String password) {
        if(email != null){
            Optional<ΜunicipalΕmployee> admin = municipalEmployeeRepository.findById(email);
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

    @Override
    @Transactional
    public void notificationOwner(@PathVariable String numberOfMicrochip) {
        Optional<Pet> optionalPet = petRepository.findById(numberOfMicrochip);
        if(optionalPet.isPresent()){
            // send email
        }
    }
}
