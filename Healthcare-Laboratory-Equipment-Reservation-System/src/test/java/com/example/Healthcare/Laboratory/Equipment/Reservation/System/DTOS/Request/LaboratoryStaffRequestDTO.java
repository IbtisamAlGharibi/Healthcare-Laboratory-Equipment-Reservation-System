package com.example.Healthcare.Laboratory.Equipment.Reservation.System.DTOS.Request;

import com.example.Healthcare.Laboratory.Equipment.Reservation.System.Entities.LaboratoryStaff;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LaboratoryStaffRequestDTO {
    private String name;
    private String email;
    private String phone;
    private String department;

    public LaboratoryStaff toEntity() {
        LaboratoryStaff laboratoryStaff = new LaboratoryStaff();
        laboratoryStaff.setName(name);
        laboratoryStaff.setEmail(email);
        laboratoryStaff.setPhone(phone);
        laboratoryStaff.setDepartment(department);
        return laboratoryStaff;
    }
}
