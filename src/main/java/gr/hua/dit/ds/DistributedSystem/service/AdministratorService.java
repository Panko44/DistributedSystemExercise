package gr.hua.dit.ds.DistributedSystem.service;

import gr.hua.dit.ds.DistributedSystem.entity.Administrator;
import gr.hua.dit.ds.DistributedSystem.entity.Citizen;
import gr.hua.dit.ds.DistributedSystem.entity.MunicipalEmployee;
import gr.hua.dit.ds.DistributedSystem.entity.Veterinary;
import gr.hua.dit.ds.DistributedSystem.entity.MunicipalEmployee;
import gr.hua.dit.ds.DistributedSystem.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface AdministratorService {

    public List<Citizen> ListCitizens();

    public List<MunicipalEmployee> ListMunicipalEmployees();

    public List<Veterinary> ListVeterinaries();

    public ResponseEntity<Object> modificationMunicipalEmployee(@RequestBody MunicipalEmployee municipalEmployee, @PathVariable Integer AMKA);

    public ResponseEntity<Object> modificationVeterinary(@RequestBody Veterinary veterinary,@PathVariable Integer AMKA);

    public ResponseEntity<Object> modificationCitizen(@RequestBody Citizen citizen,@PathVariable Integer AMKA);

    public ResponseEntity<Object> addCitizen(@RequestBody Citizen citizen);

    public ResponseEntity<Object> addMunicipalEmployee(@RequestBody MunicipalEmployee municipalEmployee);

    public ResponseEntity<Object> addVeterinary(@RequestBody Veterinary veterinary);

    public void deleteCitizen(Integer AMKA);

    public void saveCitizen(Citizen citizen);

    public void deleteMunicipalEmployee(Integer AMKA);

    public void deleteVeterinary(Integer AMKA);

    public boolean logIn(String email, String password);
}