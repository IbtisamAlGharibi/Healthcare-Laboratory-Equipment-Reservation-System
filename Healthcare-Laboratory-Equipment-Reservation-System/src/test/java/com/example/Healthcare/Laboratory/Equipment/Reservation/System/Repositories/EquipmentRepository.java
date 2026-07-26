package com.example.Healthcare.Laboratory.Equipment.Reservation.System.Repositories;

import com.example.Healthcare.Laboratory.Equipment.Reservation.System.Entities.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface EquipmentRepository  extends JpaRepository<Equipment, Integer> {

    @Query("select e from Equipment e where e.status = 'Available'")
    List<Equipment> getAllEquipment();

    @Query("select e from Equipment e where e.id = :id")
    Equipment findByEquipmentId(@Param("id") Integer id);

    @Query("select e from Equipment e where e.name = :name")
    List<Equipment> findByEquipmentName(@Param("name") String name);

    @Query("select e from Equipment e where e.status = :status")
    List<Equipment> findByStatus(@Param("status") String status);
}




