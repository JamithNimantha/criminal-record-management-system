package lk.ijse.gdse.common.dto;

public class UserDTO implements SuperDTO {
    private String ID;
    private String name;
    private String position;
    private String permissionLevel;
    private String department;
    private String address;
    private String email;
    private String telphone;
    private String password;
    private byte[] photo;

    public UserDTO() {
    }

    public UserDTO(String ID, String name, String position, String permissionLevel, String department, String address, String email, String telphone, String password, byte[] photo) {
        this.ID = ID;
        this.name = name;
        this.position = position;
        this.permissionLevel = permissionLevel;
        this.department = department;
        this.address = address;
        this.email = email;
        this.telphone = telphone;
        this.password = password;
        this.photo = photo;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
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

    public String getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(String permissionLevel) {
        this.permissionLevel = permissionLevel;
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

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", permissionLevel='" + permissionLevel + '\'' +
                ", department='" + department + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", telphone='" + telphone + '\'' +
                ", password='" + password + '\'' +
                ", photo=" + photo +
                '}';
    }
}

