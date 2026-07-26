package com.example.Healthcare.Laboratory.Equipment.Reservation.System.DTOS;

import lombok.Data;

@Data
public class LaboratoryResponseDTO {
    private Integer id;

    private String name;

    private String location;

    private String description;


    public static LaboratoryResponseDTO fromEntity(LaboratoryResponseDTO laboratoryResponseDTO) {
        LaboratoryResponseDTO dto = new LaboratoryResponseDTO();
        dto.setId(laboratoryResponseDTO.getId());
        dto.setName(laboratoryResponseDTO.getName());
        dto.setLocation(laboratoryResponseDTO.getLocation());
        dto.setDescription(laboratoryResponseDTO.getDescription());
        return dto;
    }
}



