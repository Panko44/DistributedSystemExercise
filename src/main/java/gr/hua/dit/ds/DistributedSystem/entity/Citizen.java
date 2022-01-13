package gr.hua.dit.ds.DistributedSystem.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;


@Entity
@Table(name = "citizen")
public class Citizen extends User {

    @Column(name = "address")
    private String address;

    @Column(name = "age")
    private String age;


    public Citizen(String fullName, String AMKA, String municipalHouse, String password, String email, String address, String age) {
        super(fullName, AMKA, municipalHouse, password, email);
        this.address = address;
        this.age = age;
    }

    public Citizen() {

    }

    public String getAddress() {
        return address;
    }

    public String getAge() {
        return age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(String age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Citizen{" +
                "address='" + address + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
