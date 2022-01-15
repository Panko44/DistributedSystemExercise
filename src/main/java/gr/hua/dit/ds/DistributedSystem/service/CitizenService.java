package gr.hua.dit.ds.DistributedSystem.service;

import gr.hua.dit.ds.DistributedSystem.repository.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;

public interface CitizenService {

    public void logIn();

    public void addNewPet();

    public void lostPet();

    public void findPet();

    public void registrationPersonalData();

}
