package gr.hua.dit.ds.DistributedSystem.service;

import gr.hua.dit.ds.DistributedSystem.entity.Administrator;
import gr.hua.dit.ds.DistributedSystem.entity.Veterinary;
import gr.hua.dit.ds.DistributedSystem.repository.VeterinaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.Optional;

@Service
public class VeterinaryServiceImpl implements VeterinaryService{

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private VeterinaryRepository veterinaryRepository;


    @Override
    public boolean logIn(String email, String password) {
        if(email != null){
            Optional<Veterinary> admin = veterinaryRepository.findById(email);
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
    public void examinationStatement() {

    }

    @Override
    public void confirmationData() {

    }

}
