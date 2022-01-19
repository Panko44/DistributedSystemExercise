package gr.hua.dit.ds.DistributedSystem.service;

import gr.hua.dit.ds.DistributedSystem.entity.Administrator;
import gr.hua.dit.ds.DistributedSystem.entity.ΜunicipalΕmployee;
import gr.hua.dit.ds.DistributedSystem.repository.MunicipalEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.Optional;

@Service
public class MunicipalEmployeeServiceImpl implements MunicipalEmployeeService{

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private MunicipalEmployeeRepository municipalEmployeeRepository;


    @Override
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
    public void notificationOwner() {

    }
}
