package gr.hua.dit.ds.DistributedSystem.service;

import gr.hua.dit.ds.DistributedSystem.entity.Citizen;
import gr.hua.dit.ds.DistributedSystem.repository.CitizenRepository;
import gr.hua.dit.ds.DistributedSystem.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.Optional;

@Service
public class CitizenServiceImpl implements CitizenService{

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private CitizenRepository citizenRepository;

    @Autowired
    private PetRepository petRepository;

    @Override
    public boolean logIn(String email, String password) {
        if (email != null){
            Optional<Citizen> citizen = citizenRepository.findById(email);

            if (citizen != null){
                if(citizen.get().getPassword()== password){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void addNewPet() {

    }

    @Override
    public void lostPet() {

    }

    @Override
    public void findPet() {

    }

    @Override
    public void registrationPersonalData() {

    }
}
