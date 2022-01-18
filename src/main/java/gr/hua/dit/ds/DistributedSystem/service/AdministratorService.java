package gr.hua.dit.ds.DistributedSystem.service;

import gr.hua.dit.ds.DistributedSystem.entity.Administrator;
import gr.hua.dit.ds.DistributedSystem.entity.Citizen;
import gr.hua.dit.ds.DistributedSystem.entity.Veterinary;
import gr.hua.dit.ds.DistributedSystem.entity.ΜunicipalΕmployee;
import gr.hua.dit.ds.DistributedSystem.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface AdministratorService {

    public List<Citizen> ListCitizens();

    public List<ΜunicipalΕmployee> ListMunicipalEmployees();

    public List<Veterinary> ListVeterinaries();

    public void modificationData(String AMKA);

    public ResponseEntity<Object> addCitizen(@RequestBody Citizen citizen);

    public ResponseEntity<Object> addMunicipalEmployee(@RequestBody ΜunicipalΕmployee municipalEmployee);

    public ResponseEntity<Object> addVeterinary(@RequestBody Veterinary veterinary);

    public void deleteCitizen(String AMKA);

    public void deleteMunicipalEmployee(String AMKA);

    public void deleteVeterinary(String AMKA);

    public void logIn();

    boolean logIn(String email, String password);
}
