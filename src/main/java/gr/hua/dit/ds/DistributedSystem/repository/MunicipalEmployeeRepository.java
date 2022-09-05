package gr.hua.dit.ds.DistributedSystem.repository;


import gr.hua.dit.ds.DistributedSystem.entity.MunicipalEmployee;
import gr.hua.dit.ds.DistributedSystem.entity.MunicipalEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MunicipalEmployeeRepository extends JpaRepository<MunicipalEmployee,Integer>{

}
