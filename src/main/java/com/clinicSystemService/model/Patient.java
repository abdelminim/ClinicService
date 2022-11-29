package com.clinicSystemService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "patient", schema = "clinic")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Patient {

    @Id
    @Column(name = "id",length = 2,nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "sick_name", columnDefinition = "NVARCHAR",length = 100)
    private String sickName;

    @Column(name = "age")
    private Integer age;


    @Column(name = "address", columnDefinition = "NVARCHAR",length = 50)
    private String address;

    @Column(name = "appointment_Id")
    private Integer appointmentId;

//    @OneToMany(mappedBy="patient")
//    private Set<Appointment> appointments;



}
