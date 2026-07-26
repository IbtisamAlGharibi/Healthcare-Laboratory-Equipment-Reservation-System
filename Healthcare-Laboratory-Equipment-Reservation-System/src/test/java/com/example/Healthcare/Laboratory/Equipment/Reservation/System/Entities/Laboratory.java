package com.example.Healthcare.Laboratory.Equipment.Reservation.System.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Laboratory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String location;

    private String description;


    @OneToMany(mappedBy = "laboratory", cascade = CascadeType.ALL)
    private List<Equipment> equipments = new ArrayList<>();
}

