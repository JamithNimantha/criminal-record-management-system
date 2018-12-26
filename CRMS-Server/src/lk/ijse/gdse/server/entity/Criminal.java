package lk.ijse.gdse.server.entity;


import javax.persistence.*;

@Entity
@Table(name = "Criminal")
public class Criminal {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "record_name")
    private String record_name;
    @Column (name = "record_description")
    private String record_description;
    @Column(name = "victim_name")
    private String victim_name;
    @Column(name = "incident_location")
    private String incident_location;

 //   @Column

}
