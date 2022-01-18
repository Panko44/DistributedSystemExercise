package gr.hua.dit.ds.DistributedSystem.service;

import gr.hua.dit.ds.DistributedSystem.repository.VeterinaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class VeterinaryServiceImpl implements VeterinaryService{

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private VeterinaryRepository veterinaryRepository;

    public void logIn(){

    }

    public void examinationStatement(){

    }

    public void updateΑnimalΗistory(){

    }

    public void confirmationData(){

    }

}
