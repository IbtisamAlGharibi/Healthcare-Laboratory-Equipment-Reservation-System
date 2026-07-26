package com.example.Healthcare.Laboratory.Equipment.Reservation.System.Controllers;

import com.example.Healthcare.Laboratory.Equipment.Reservation.System.DTOS.LaboratoryResponseDTO;
import com.example.Healthcare.Laboratory.Equipment.Reservation.System.Services.LaboratoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/laboratories")
public class LaboratoryController {

    @Autowired
    private LaboratoryService laboratoryService;


    public LaboratoryController(LaboratoryService laboratoryService) {
        this.laboratoryService = laboratoryService;
    }


    @GetMapping
    public List<LaboratoryResponseDTO> getAllLaboratories(){

        return laboratoryService.getAllLaboratories();
    }


    @GetMapping("/{id}")
    public LaboratoryResponseDTO getLaboratoryById(@PathVariable Integer id){

        return laboratoryService.getLaboratoryById(id);
    }


    @PostMapping
    public LaboratoryResponseDTO addLaboratory(@RequestBody LaboratoryResponseDTO dto){

        return laboratoryService.addLaboratory(dto);
    }


    @PutMapping("/{id}")
    public LaboratoryResponseDTO updateLaboratory(@PathVariable Integer id, @RequestBody LaboratoryResponseDTO dto){

        return laboratoryService.updateLaboratory(id, dto);
    }


    @DeleteMapping("/{id}")
    public void deleteLaboratory(@PathVariable Integer id){

        laboratoryService.deleteLaboratory(id);
    }
}

