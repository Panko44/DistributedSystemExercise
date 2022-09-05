package gr.hua.dit.ds.DistributedSystem.service;

import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;

public interface MunicipalEmployeeService {

    //public boolean logIn(String email, String password);


    @Transactional
    void notificationOwner(@PathVariable Integer numberOfMicrochip);
}
