package gr.hua.dit.ds.DistributedSystem.service;

import gr.hua.dit.ds.DistributedSystem.repository.MunicipalEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class MunicipalEmployeeServiceImpl implements MunicipalEmployeeService{

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private MunicipalEmployeeRepository municipalEmployeeRepository;


    @Override
    public void logIn() {

    }

    @Override
    public void notificationOwner() {

    }
}
