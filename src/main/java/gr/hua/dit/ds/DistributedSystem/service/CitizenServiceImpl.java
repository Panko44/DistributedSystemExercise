package gr.hua.dit.ds.DistributedSystem.service;

import gr.hua.dit.ds.DistributedSystem.repository.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class CitizenServiceImpl implements CitizenService{

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private CitizenRepository citizenRepository;

    public void logIn(){

    }

    public void addNewPet(){

    }

    public void lostPet(){

    }

    public void findPet(){

    }

    public void registrationPersonalData(){

    }

}
