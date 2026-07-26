package com.example.Healthcare.Laboratory.Equipment.Reservation.System.Services;

import com.example.Healthcare.Laboratory.Equipment.Reservation.System.Entities.LaboratoryStaff;
import com.example.Healthcare.Laboratory.Equipment.Reservation.System.Repositories.LaboratoryStaffRepository;
import com.example.Healthcare.Laboratory.Equipment.Reservation.System.Repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaboratoryStaffService {
    LaboratoryStaffRepository laboratoryStaffRepository;
    ReservationRepository reservationRepository;

    @Autowired
    public LaboratoryStaffService(LaboratoryStaffRepository laboratoryStaffRepository, ReservationRepository reservationRepository) {
        this.laboratoryStaffRepository = laboratoryStaffRepository;
        this.reservationRepository = reservationRepository;
    }

    public LaboratoryStaff addLaboratoryStaff(LaboratoryStaff laboratoryStaff){
        LaboratoryStaff newLaboratoryStaff = new LaboratoryStaff();
        newLaboratoryStaff.setName(laboratoryStaff.getName());
        newLaboratoryStaff.setPhone(laboratoryStaff.getPhone());
        newLaboratoryStaff.setEmail(laboratoryStaff.getEmail());
        newLaboratoryStaff.setDepartment(laboratoryStaff.getDepartment());
        newLaboratoryStaff.setIsActive(laboratoryStaff.getIsActive());
        laboratoryStaffRepository.save(newLaboratoryStaff);
        return newLaboratoryStaff;
    }
}
