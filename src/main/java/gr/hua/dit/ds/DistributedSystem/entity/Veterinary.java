package gr.hua.dit.ds.DistributedSystem.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "vet")
public class Veterinary extends User{

    @Column(name = "age")
    private String age;

    public Veterinary() {
    }

    public Veterinary(String fullName, String AMKA, String municipalHouse, String password, String email) {
        super(fullName, AMKA, municipalHouse, password, email);
    }

    public Veterinary(String fullName, String AMKA, String municipalHouse, String password, String email, String age) {
        super(fullName, AMKA, municipalHouse, password, email);
        this.age = age;
    }

    public String getAge() {
        return age;
    }

    @Override
    public String getFullName() {
        return super.getFullName();
    }

    @Override
    public String getAMKA() {
        return super.getAMKA();
    }

    @Override
    public String getMunicipalHouse() {
        return super.getMunicipalHouse();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public void setFullName(String fullName) {
        super.setFullName(fullName);
    }

    @Override
    public void setAMKA(String AMKA) {
        super.setAMKA(AMKA);
    }

    @Override
    public void setMunicipalHouse(String municipalHouse) {
        super.setMunicipalHouse(municipalHouse);
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }

    public void setAge(String age) {
        this.age = age;
    }



    @Override
    public String toString() {
        return "Veterinary{" +
                "age='" + getAge() + "\t" +"AMKA:"+getAMKA()+"\t email:"+getEmail()+"\t FullName:"+getFullName()+"\t Password:"+getPassword()+"\t MunicipalHouse"+getMunicipalHouse()+
                '}';
    }
}
