package com.clinicSystemService.model;

import com.clinicSystemService.model.composite.AppointmentComposite;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Appointment", schema = "dbo", catalog = "Clinic")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
//@IdClass(AppointmentComposite.class)
public class Appointment implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name = "appointmentDate")
    private Date appointmentDate ;

    @Column(name = "patientId")
    private Integer patientId;

    @Column(name = "appointmentState")//1 new 2 canceled 3 ordered
    private Integer appointmentState =0;

    @Column(name = "cancelReason")
    private String cancelReason;

    @Column(name = "placeOfDetection")
    private String placeOfDetection;

//    @ManyToOne
//    @JoinColumn(name="appointment_Id", nullable=false)
//    private Patient patient;

}
