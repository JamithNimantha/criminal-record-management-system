package lk.ijse.gdse.server.entity;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name = "User")
public class User {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "position")
    private String position;
    @Column(name = "permission_level")
    private String permission_level;
    @Column(name = "department")
    private String department;
    @Column(name = "address")
    private String address;
    @Column(name = "email")
    private String email;
    @Column(name = "telphone")
    private String telphone;
    @Column(name = "password")
    private String password;
    @Lob
    @Column(name = "photo")
    private Blob photo;

    public User() {
    }

    public User(String id, String name, String position, String permission_level, String department, String address, String email, String telphone, String password, Blob photo) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.permission_level = permission_level;
        this.department = department;
        this.address = address;
        this.email = email;
        this.telphone = telphone;
        this.password = password;
        this.photo = photo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPermission_level() {
        return permission_level;
    }

    public void setPermission_level(String permission_level) {
        this.permission_level = permission_level;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Blob getPhoto() {
        return photo;
    }

    public void setPhoto(Blob photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", permission_level='" + permission_level + '\'' +
                ", department='" + department + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", telphone='" + telphone + '\'' +
                ", password='" + password + '\'' +
                ", photo=" + photo +
                '}';
    }
}
