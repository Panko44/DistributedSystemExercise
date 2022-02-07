package gr.hua.dit.ds.DistributedSystem.entity;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "pet")
public class Pet {

    @Column(name = "race")
    private String race;

    @Column(name = "gender")
    private String gender;

    @Column(name = "dateofbirth")
    private String dateOfBirth;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "numberofmicrochip")
    private String numberOfMicrochip;

    @Column(name = "amkaowner")
    private String amkaOwmer;

    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="amkaowmer")
    private Citizen citizen;

    @ManyToMany(fetch=FetchType.LAZY,
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name= "vet_pet",
            joinColumns= {@JoinColumn(name = "vet_amka")},
            inverseJoinColumns= {@JoinColumn(name = "pet_microchip")}
    )
    private List<ΜunicipalΕmployee> ΜunicipalΕmployeeList;

    @ManyToMany(fetch=FetchType.LAZY,
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name="municipalEmployee_pet",
            joinColumns=@JoinColumn(name="municipalEmployee_amka"),
            inverseJoinColumns=@JoinColumn(name="pet_microchip"))
    private List<Pet> petList;

    public Pet(String race, String gender, String dateOfBirth, String numberOfMicrochip, String amkaOwmer) {
        this.race = race;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.numberOfMicrochip = numberOfMicrochip;
        this.amkaOwmer = amkaOwmer;
    }

    public Pet(){}

    public String getRace() {
        return race;
    }

    public String getGender() {
        return gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getNumberOfMicrochip() {
        return numberOfMicrochip;
    }

    public String getAmkaOwmer() {
        return amkaOwmer;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setNumberOfMicrochip(String numberOfMicrochip) {
        this.numberOfMicrochip = numberOfMicrochip;
    }

    public void setAmkaOwmer(String amkaOwmer) {
        this.amkaOwmer = amkaOwmer;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "race='" + race + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", numberOfMicrochip='" + numberOfMicrochip + '\'' +
                ", amkaOwmer='" + amkaOwmer + '\'' +
                '}';
    }
}
