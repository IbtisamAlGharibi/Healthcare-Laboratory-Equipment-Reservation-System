package com.example.Healthcare.Laboratory.Equipment.Reservation.System.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private LocalDate reservationDate;

    @Column(nullable = false)
    private LocalTime startTime;

    @Column(nullable = false)
    private LocalTime endTime;

    @Column(nullable = false)
    private String purpose;

    @Column(nullable = false)
    private String status;

   /* @ManyToOne
    @JoinColumn(name = "equipment_id", nullable = false)
    private Equipment equipment;*/

    @ManyToOne
    @JoinColumn(name = "laboratory_staff_id", nullable = false)
    private LaboratoryStaff laboratoryStaff;
}
