package gr.hua.dit.ds.DistributedSystem.repository;

import gr.hua.dit.ds.DistributedSystem.entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen,String>{

}
