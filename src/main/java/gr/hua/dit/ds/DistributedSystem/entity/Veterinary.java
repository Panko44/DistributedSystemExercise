package gr.hua.dit.ds.DistributedSystem.entity;

import javax.persistence.*;

@Entity
@Table(name = "vet")
public class Veterinary{

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

    @Column(name = "age")
    private String age;

    public Veterinary() {
    }

    public Veterinary(String fullName, String AMKA, String municipalHouse, String password, String email, String age) {
        this.fullName = fullName;
        this.AMKA = AMKA;
        this.municipalHouse = municipalHouse;
        this.password = password;
        this.email = email;
        this.age = age;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Veterinary{" +
                "fullName='" + fullName + '\'' +
                ", AMKA='" + AMKA + '\'' +
                ", municipalHouse='" + municipalHouse + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
