package gr.hua.dit.ds.DistributedSystem.controller;

import gr.hua.dit.ds.DistributedSystem.entity.Administrator;
import gr.hua.dit.ds.DistributedSystem.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class AdministatorController {

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
