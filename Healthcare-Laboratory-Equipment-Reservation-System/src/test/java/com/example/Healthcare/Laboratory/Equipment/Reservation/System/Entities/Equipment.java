package com.example.Healthcare.Laboratory.Equipment.Reservation.System.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String serialNumber;

    private String status;

    private LocalDate purchaseDate;

    @ManyToOne
    @JoinColumn(name = "laboratory_id")
    private Laboratory laboratory;


    @OneToMany(mappedBy = "equipment")
    private List<Reservation> reservations;

/*
    @OneToMany(mappedBy = "equipment")
    private List<Maintenance> maintenances;*/
}



