package gr.hua.dit.ds.DistributedSystem.service;

import gr.hua.dit.ds.DistributedSystem.entity.Administrator;
import gr.hua.dit.ds.DistributedSystem.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private AdministratorRepository administratorRepository;

    public List<Administrator> ListUsers(){
        return  administratorRepository.findAll();
    }


    public void PrintUser(){

    }

    public void modificationData(){

    }

    public void addUser(){

    }

    public void deleteUser(){

    }

    public void logIn(){

    }

}
