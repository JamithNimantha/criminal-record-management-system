package lk.ijse.gdse.server.entity;


import javax.persistence.*;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Criminal")
public class Criminal {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String criminalId;
    private String criminalName;
    private String criminalNickName;
    private String criminalNIC;
    @Temporal(TemporalType.DATE)
    private Date criminalDOB;
    private int age;
    private String gender;
    private String birthRegID;
    private String birthPlace;
    private String civilStatus;
    private String occupation;
    private String address;
    private String ethnicity;
    private String politicalView;
    private String religion;
    private double height;
    private String complexion;
    private String hair;
    private String eyes;
    private Blob photo;

    @OneToMany(mappedBy = "criminal")
    private List<CriminalRecordDetails> criminalRecordDetails=new ArrayList<>();

    public Criminal() {
    }

    public Criminal(String criminalId, String criminalName, String criminalNickName, String criminalNIC, Date criminalDOB, int age, String gender, String birthRegID, String birthPlace, String civilStatus, String occupation, String address, String ethnicity, String politicalView, String religion, double height, String complexion, String hair, String eyes, Blob photo) {
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
        this.politicalView = politicalView;
        this.religion = religion;
        this.height = height;
        this.complexion = complexion;
        this.hair = hair;
        this.eyes = eyes;
        this.photo = photo;
    }

    public Criminal(String criminalId, String criminalName, String criminalNickName, String criminalNIC, Date criminalDOB, int age, String gender, String birthRegID, String birthPlace, String civilStatus, String occupation, String address, String ethnicity, String politicalView, String religion, double height, String complexion, String hair, String eyes, Blob photo, List<CriminalRecordDetails> criminalRecordDetails) {
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
        this.politicalView = politicalView;
        this.religion = religion;
        this.height = height;
        this.complexion = complexion;
        this.hair = hair;
        this.eyes = eyes;
        this.photo = photo;
        this.criminalRecordDetails = criminalRecordDetails;
    }

//    public Criminal(String criminalName, String criminalNickName, String criminalNIC, String criminalDOB, int age, String gender, String birthRegID, String birthPlace, String civilStatus, String occupation, String address, String ethnicity, String politicalView, String religion, double height, String complexion, String hair, String eyes, Blob photo) {
//        this.criminalName = criminalName;
//        this.criminalNickName = criminalNickName;
//        this.criminalNIC = criminalNIC;
//        this.criminalDOB = criminalDOB;
//        this.age = age;
//        this.gender = gender;
//        this.birthRegID = birthRegID;
//        this.birthPlace = birthPlace;
//        this.civilStatus = civilStatus;
//        this.occupation = occupation;
//        this.address = address;
//        this.ethnicity = ethnicity;
//        this.politicalView = politicalView;
//        this.religion = religion;
//        this.height = height;
//        this.complexion = complexion;
//        this.hair = hair;
//        this.eyes = eyes;
//        this.photo = photo;
//    }
//
//    public Criminal(String criminalName, String criminalNickName, String criminalNIC, String criminalDOB, int age, String gender, String birthRegID, String birthPlace, String civilStatus, String occupation, String address, String ethnicity, String politicalView, String religion, double height, String complexion, String hair, String eyes, Blob photo, List<CriminalRecordDetails> criminalRecordDetails) {
//        this.criminalName = criminalName;
//        this.criminalNickName = criminalNickName;
//        this.criminalNIC = criminalNIC;
//        this.criminalDOB = criminalDOB;
//        this.age = age;
//        this.gender = gender;
//        this.birthRegID = birthRegID;
//        this.birthPlace = birthPlace;
//        this.civilStatus = civilStatus;
//        this.occupation = occupation;
//        this.address = address;
//        this.ethnicity = ethnicity;
//        this.politicalView = politicalView;
//        this.religion = religion;
//        this.height = height;
//        this.complexion = complexion;
//        this.hair = hair;
//        this.eyes = eyes;
//        this.photo = photo;
//        this.criminalRecordDetails = criminalRecordDetails;
//    }



    public String getCriminalId() {
        return criminalId;
    }

    public void setCriminalId(String criminalId) {
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

    public Date getCriminalDOB() {
        return criminalDOB;
    }

    public void setCriminalDOB(Date criminalDOB) {
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

    public String getPoliticalView() {
        return politicalView;
    }

    public void setPoliticalView(String politicalView) {
        this.politicalView = politicalView;
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

    public Blob getPhoto() {
        return photo;
    }

    public void setPhoto(Blob photo) {
        this.photo = photo;
    }

    public List<CriminalRecordDetails> getCriminalRecordDetails() {
        return criminalRecordDetails;
    }

    public void setCriminalRecordDetails(List<CriminalRecordDetails> criminalRecordDetails) {
        this.criminalRecordDetails = criminalRecordDetails;
    }

    @Override
    public String toString() {
        return "Criminal{" +
                "criminalId=" + criminalId +
                ", criminalName='" + criminalName + '\'' +
                ", criminalNickName='" + criminalNickName + '\'' +
                ", criminalNIC='" + criminalNIC + '\'' +
                ", criminalDOB='" + criminalDOB + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", birthRegID='" + birthRegID + '\'' +
                ", birthPlace='" + birthPlace + '\'' +
                ", civilStatus='" + civilStatus + '\'' +
                ", occupation='" + occupation + '\'' +
                ", address='" + address + '\'' +
                ", ethnicity='" + ethnicity + '\'' +
                ", politicalView='" + politicalView + '\'' +
                ", religion='" + religion + '\'' +
                ", height=" + height +
                ", complexion='" + complexion + '\'' +
                ", hair='" + hair + '\'' +
                ", eyes='" + eyes + '\'' +
                ", photo=" + photo +
                ", criminalRecordDetails=" + criminalRecordDetails +
                '}';
    }
}
