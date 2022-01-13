package gr.hua.dit.ds.DistributedSystem.repository;

import gr.hua.dit.ds.DistributedSystem.entity.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator,String> {

}
