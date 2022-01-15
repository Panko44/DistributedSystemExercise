package gr.hua.dit.ds.DistributedSystem.service;

import gr.hua.dit.ds.DistributedSystem.entity.Administrator;
import gr.hua.dit.ds.DistributedSystem.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface AdministratorService {

    public List<Administrator> ListUsers();

    public void PrintUser();

    public void modificationData();

    public void addUser();

    public void deleteUser();

    public void logIn();

}
