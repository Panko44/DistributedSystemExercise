package gr.hua.dit.ds.DistributedSystem.entity;

import javax.persistence.*;

@Entity
@Table(name = "municipalΕmployee")
public class ΜunicipalΕmployee {

    @Column(name = "fullName")
    private String fullName;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "AMKA")
    private String AMKA;

    @Column(name = "municipalHouse")
    private String municipalHouse;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    public ΜunicipalΕmployee(String fullName, String AMKA, String municipalHouse, String password, String email) {
        this.fullName = fullName;
        this.AMKA = AMKA;
        this.municipalHouse = municipalHouse;
        this.password = password;
        this.email = email;
    }

    public ΜunicipalΕmployee() {

    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAMKA() {
        return AMKA;
    }

    public void setAMKA(String AMKA) {
        this.AMKA = AMKA;
    }

    public String getMunicipalHouse() {
        return municipalHouse;
    }

    public void setMunicipalHouse(String municipalHouse) {
        this.municipalHouse = municipalHouse;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ΜunicipalΕmployee{" +
                "fullName='" + fullName + '\'' +
                ", AMKA='" + AMKA + '\'' +
                ", municipalHouse='" + municipalHouse + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
