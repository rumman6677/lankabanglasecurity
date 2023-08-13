package com.lonkabangla.secutries.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Nominee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String shotName;
    private String nameTitle;
    private String relationWithNominee;
    private String percentage;

    @OneToOne
    @JoinColumn(columnDefinition = "a_id",referencedColumnName = "id")
    private Address address;
    private String telephone;
    private String mobileNumber;
    private String fax;
    private String email;
    private String residency;
    private String nationality;
    private Date dateOfBirth;

    @OneToOne
    @JoinColumn(name = "p_id",referencedColumnName = "id")
    private PassPort passPort;

    private boolean isMinor;

    public boolean isMinor() {
        return isMinor;
    }

    public void setMinor(boolean minor) {
        isMinor = minor;
    }

    @OneToOne
    @JoinColumn(name = "g_id",referencedColumnName = "id")
    private Nominee gerdian;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShotName() {
        return shotName;
    }

    public void setShotName(String shotName) {
        this.shotName = shotName;
    }

    public String getNameTitle() {
        return nameTitle;
    }

    public void setNameTitle(String nameTitle) {
        this.nameTitle = nameTitle;
    }

    public String getRelationWithNominee() {
        return relationWithNominee;
    }

    public void setRelationWithNominee(String relationWithNominee) {
        this.relationWithNominee = relationWithNominee;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getResidency() {
        return residency;
    }

    public void setResidency(String residency) {
        this.residency = residency;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public PassPort getPassPort() {
        return passPort;
    }

    public void setPassPort(PassPort passPort) {
        this.passPort = passPort;
    }

    public Nominee getGerdian() {
        return gerdian;
    }

    public void setGerdian(Nominee gerdian) {
        this.gerdian = gerdian;
    }
}
