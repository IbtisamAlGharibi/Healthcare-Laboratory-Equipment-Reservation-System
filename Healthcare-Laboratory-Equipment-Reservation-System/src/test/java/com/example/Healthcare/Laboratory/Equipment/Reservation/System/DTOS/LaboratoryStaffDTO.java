package com.example.Healthcare.Laboratory.Equipment.Reservation.System.DTOS;

import com.example.Healthcare.Laboratory.Equipment.Reservation.System.Entities.LaboratoryStaff;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LaboratoryStaffDTO {
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private String department;
    private Boolean isActive;

    public static LaboratoryStaffDTO fromEntity(LaboratoryStaff laboratoryStaff) {
        LaboratoryStaffDTO dto = new LaboratoryStaffDTO();
        dto.setId(laboratoryStaff.getId());
        dto.setName(laboratoryStaff.getName());
        dto.setEmail(laboratoryStaff.getEmail());
        dto.setPhone(laboratoryStaff.getPhone());
        dto.setDepartment(laboratoryStaff.getDepartment());
        dto.setIsActive(laboratoryStaff.getIsActive());
        return dto;
    }
}
