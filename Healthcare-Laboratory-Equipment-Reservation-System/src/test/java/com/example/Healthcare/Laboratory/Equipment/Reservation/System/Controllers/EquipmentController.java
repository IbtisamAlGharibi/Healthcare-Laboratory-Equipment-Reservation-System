package com.example.Healthcare.Laboratory.Equipment.Reservation.System.Controllers;

import com.example.Healthcare.Laboratory.Equipment.Reservation.System.DTOS.EquipmentResponseDTO;
import com.example.Healthcare.Laboratory.Equipment.Reservation.System.Services.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;


    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }


    @GetMapping
    public List<EquipmentResponseDTO> getAll(){

        return equipmentService.getAllEquipment();
    }
    @GetMapping("/{id}")
    public EquipmentResponseDTO getById(@PathVariable Integer id){

        return equipmentService.getEquipmentById(id);
    }


    @PostMapping
    public EquipmentResponseDTO create(@RequestBody EquipmentResponseDTO dto){

        return equipmentService.addEquipment(dto);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){

        equipmentService.deleteEquipment(id);
    }
}