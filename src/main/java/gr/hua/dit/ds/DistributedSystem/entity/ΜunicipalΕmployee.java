package gr.hua.dit.ds.DistributedSystem.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "municipalΕmployee")
public class ΜunicipalΕmployee {

    @Column(name = "fullName")
    private String fullName;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "AMKA")
    private int AMKA;

    @Column(name = "municipalHouse")
    private String municipalHouse;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    public ΜunicipalΕmployee(String fullName, int AMKA, String municipalHouse, String password, String email) {
        this.fullName = fullName;
        this.AMKA = AMKA;
        this.municipalHouse = municipalHouse;
        this.password = password;
        this.email = email;
    }

    @ManyToMany(fetch=FetchType.LAZY,
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name="municipalEmployee_pet",
            joinColumns=@JoinColumn(name="municipalEmployee_amka"),
            inverseJoinColumns=@JoinColumn(name="pet_microchip"))
    private List<Pet> petList;

    @ManyToMany(fetch=FetchType.LAZY,
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name="municipalEmployee_citizen",
            joinColumns=@JoinColumn(name="municipalEmployee_amka"),
            inverseJoinColumns=@JoinColumn(name="citizen_amka"))
    private List<Citizen> citizenList;

    public ΜunicipalΕmployee() {

    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAMKA() {
        return AMKA;
    }

    public void setAMKA(int AMKA) {
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
