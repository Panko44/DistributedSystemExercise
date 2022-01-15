package gr.hua.dit.ds.DistributedSystem.entity;

import javax.persistence.*;


@Entity
@Table(name = "citizen")
public class Citizen {

    @Column(name = "address")
    private String address;

    @Column(name = "age")
    private String age;

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

    public Citizen(String address, String age, String fullName, String AMKA, String municipalHouse, String password, String email) {
        this.address = address;
        this.age = age;
        this.fullName = fullName;
        this.AMKA = AMKA;
        this.municipalHouse = municipalHouse;
        this.password = password;
        this.email = email;
    }

    public Citizen() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
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

    @Override
    public String toString() {
        return "Citizen{" +
                "address='" + address + '\'' +
                ", age='" + age + '\'' +
                ", fullName='" + fullName + '\'' +
                ", AMKA='" + AMKA + '\'' +
                ", municipalHouse='" + municipalHouse + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
