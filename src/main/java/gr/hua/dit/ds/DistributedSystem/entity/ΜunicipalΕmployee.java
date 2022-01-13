package gr.hua.dit.ds.DistributedSystem.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "municipalΕmployee")
public class ΜunicipalΕmployee extends User {
    public ΜunicipalΕmployee(String fullName, String AMKA, String municipalHouse, String password, String email) {
        super(fullName, AMKA, municipalHouse, password, email);
    }

    public ΜunicipalΕmployee() {

    }
}
