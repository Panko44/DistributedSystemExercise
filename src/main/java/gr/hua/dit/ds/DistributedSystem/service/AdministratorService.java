package gr.hua.dit.ds.DistributedSystem.service;

import gr.hua.dit.ds.DistributedSystem.entity.Administrator;
import gr.hua.dit.ds.DistributedSystem.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface AdministratorService {

    public void PrintCitizens();

    public void PrintMunicipalEmployees();

    public void PrintVeterinaries();

    public void modificationData(Integer AMKA);

    public void addCitizen();

    public void addMunicipalEmployee();

    public void addVeterinary();

    public void deleteCitizen(Integer AMKA);

    public void deleteMunicipalEmployee(Integer AMKA);

    public void deleteVeterinary(Integer AMKA);

    public void logIn();

    boolean logIn(String email, String password);
}
