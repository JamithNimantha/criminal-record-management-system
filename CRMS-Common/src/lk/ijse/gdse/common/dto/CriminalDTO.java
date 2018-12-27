package lk.ijse.gdse.common.dto;

import java.sql.Blob;
import java.util.Date;

public class CriminalDTO implements SuperDTO{
    private int criminalId;
    private String criminalName;
    private String criminalNickName;
    private String criminalNIC;
    private String criminalDOB;
    private int age;
    private String gender;
    private String birthRegID;
    private String birthPlace;
    private String civilStatus;
    private String occupation;
    private String address;
    private String ethnicity;
    private String poloticalView;
    private String religion;
    private double height;
    private String complexion;
    private String hair;
    private String eyes;
    //private Blob photo;


    public CriminalDTO() {
    }

    public CriminalDTO(int criminalId, String criminalName, String criminalNickName, String criminalNIC, String criminalDOB, int age, String gender, String birthRegID, String birthPlace, String civilStatus, String occupation, String address, String ethnicity, String poloticalView, String religion, double height, String complexion, String hair, String eyes) {
        this.criminalId = criminalId;
        this.criminalName = criminalName;
        this.criminalNickName = criminalNickName;
        this.criminalNIC = criminalNIC;
        this.criminalDOB = criminalDOB;
        this.age = age;
        this.gender = gender;
        this.birthRegID = birthRegID;
        this.birthPlace = birthPlace;
        this.civilStatus = civilStatus;
        this.occupation = occupation;
        this.address = address;
        this.ethnicity = ethnicity;
        this.poloticalView = poloticalView;
        this.religion = religion;
        this.height = height;
        this.complexion = complexion;
        this.hair = hair;
        this.eyes = eyes;
    }

    public int getCriminalId() {
        return criminalId;
    }

    public void setCriminalId(int criminalId) {
        this.criminalId = criminalId;
    }

    public String getCriminalName() {
        return criminalName;
    }

    public void setCriminalName(String criminalName) {
        this.criminalName = criminalName;
    }

    public String getCriminalNickName() {
        return criminalNickName;
    }

    public void setCriminalNickName(String criminalNickName) {
        this.criminalNickName = criminalNickName;
    }

    public String getCriminalNIC() {
        return criminalNIC;
    }

    public void setCriminalNIC(String criminalNIC) {
        this.criminalNIC = criminalNIC;
    }

    public String getCriminalDOB() {

        return criminalDOB;
    }

    public void setCriminalDOB(String criminalDOB) {
        this.criminalDOB = criminalDOB;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthRegID() {
        return birthRegID;
    }

    public void setBirthRegID(String birthRegID) {
        this.birthRegID = birthRegID;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getCivilStatus() {
        return civilStatus;
    }

    public void setCivilStatus(String civilStatus) {
        this.civilStatus = civilStatus;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getPoloticalView() {
        return poloticalView;
    }

    public void setPoloticalView(String poloticalView) {
        this.poloticalView = poloticalView;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getComplexion() {
        return complexion;
    }

    public void setComplexion(String complexion) {
        this.complexion = complexion;
    }

    public String getHair() {
        return hair;
    }

    public void setHair(String hair) {
        this.hair = hair;
    }

    public String getEyes() {
        return eyes;
    }

    public void setEyes(String eyes) {
        this.eyes = eyes;
    }


}
