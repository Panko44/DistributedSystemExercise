package gr.hua.dit.ds.DistributedSystem.service;

import org.springframework.web.bind.annotation.PathVariable;

public interface MunicipalEmployeeService {

    public boolean logIn(String email, String password);
    public void notificationOwner(@PathVariable String numberOfMicrochip);

}
