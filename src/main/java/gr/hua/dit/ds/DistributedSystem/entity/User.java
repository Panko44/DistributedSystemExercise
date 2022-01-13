package gr.hua.dit.ds.DistributedSystem.entity;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

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

    public User() {

    }

    public User(String fullName, String AMKA, String municipalHouse, String password, String email) {
        this.fullName = fullName;
        this.AMKA = AMKA;
        this.municipalHouse = municipalHouse;
        this.password = password;
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAMKA() {
        return AMKA;
    }

    public String getMunicipalHouse() {
        return municipalHouse;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAMKA(String AMKA) {
        this.AMKA = AMKA;
    }

    public void setMunicipalHouse(String municipalHouse) {
        this.municipalHouse = municipalHouse;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void logIn(){

    }

    @Override
    public String toString() {
        return "User{" +
                "fullName='" + fullName + '\'' +
                ", AMKA='" + AMKA + '\'' +
                ", municipalHouse='" + municipalHouse + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
