package gr.hua.dit.ds.DistributedSystem.controller;

import gr.hua.dit.ds.DistributedSystem.repository.MunicipalEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MunicipalEmployeeController {

    @Autowired
    private MunicipalEmployeeRepository municipalEmployeeRepository;

    public void notificationOwner(){

    }
}
