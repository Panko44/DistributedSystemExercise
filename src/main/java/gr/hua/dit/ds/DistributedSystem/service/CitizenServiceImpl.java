package gr.hua.dit.ds.DistributedSystem.service;

import gr.hua.dit.ds.DistributedSystem.entity.Citizen;
import gr.hua.dit.ds.DistributedSystem.entity.Pet;
import gr.hua.dit.ds.DistributedSystem.entity.ΜunicipalΕmployee;
import gr.hua.dit.ds.DistributedSystem.repository.CitizenRepository;
import gr.hua.dit.ds.DistributedSystem.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityManager;
import java.net.URI;
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
    public ResponseEntity<Object> addNewPet(@RequestBody Pet pet) {
        Pet savedPet = petRepository.save(pet);
        System.out.println("pet: number of microchip"+savedPet.getNumberOfMicrochip());

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{numberOfMicrochip}").buildAndExpand(savedPet.getAmkaOwmer()).toUri();
        return ResponseEntity.created(location).build();
    }

    //Κάνει μια δήλωση ότι έχασε το κατοικίδιο του
    @Override
    public void lostPet() {

    }

    //Κάνει μια δήλωση ότι βρήκε ένα κατοικίδιο κάποιου άλλου ιδιοκτήτη
    @Override
    public void findPet() {

    }
}