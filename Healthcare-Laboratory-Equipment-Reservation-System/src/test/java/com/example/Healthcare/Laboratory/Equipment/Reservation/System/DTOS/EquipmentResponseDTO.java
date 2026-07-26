package com.example.Healthcare.Laboratory.Equipment.Reservation.System.DTOS;

import com.example.Healthcare.Laboratory.Equipment.Reservation.System.Entities.LaboratoryStaff;
import lombok.Data;

import java.time.LocalDate;
@Data
public class EquipmentResponseDTO {

    private Integer id;

    private String name;

    private String serialNumber;

    private String status;

    private LocalDate purchaseDate;

    private String laboratoryName;


    public static EquipmentResponseDTO fromEntity(EquipmentResponseDTO equipmentResponse) {
        EquipmentResponseDTO dto = new EquipmentResponseDTO();
        dto.setId(equipmentResponse.getId());
        dto.setName(equipmentResponse.getName());
        dto.setSerialNumber(equipmentResponse.getSerialNumber());
        dto.setStatus(equipmentResponse.getStatus());
        dto.setPurchaseDate(equipmentResponse.getPurchaseDate());
        dto.setLaboratoryName(equipmentResponse.getLaboratoryName());
        return dto;
    }
}


