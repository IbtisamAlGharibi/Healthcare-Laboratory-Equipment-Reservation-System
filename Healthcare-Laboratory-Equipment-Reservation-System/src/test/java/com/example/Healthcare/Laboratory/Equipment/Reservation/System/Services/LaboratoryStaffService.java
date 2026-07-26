package com.example.Healthcare.Laboratory.Equipment.Reservation.System.Services;

import com.example.Healthcare.Laboratory.Equipment.Reservation.System.Entities.LaboratoryStaff;
import com.example.Healthcare.Laboratory.Equipment.Reservation.System.Repositories.LaboratoryStaffRepository;
import com.example.Healthcare.Laboratory.Equipment.Reservation.System.Repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public LaboratoryStaff updateLaboratoryStaff(LaboratoryStaff laboratoryStaff){
        LaboratoryStaff updatedLaboratoryStaff = new LaboratoryStaff();
        updatedLaboratoryStaff.setName(laboratoryStaff.getName());
        updatedLaboratoryStaff.setPhone(laboratoryStaff.getPhone());
        updatedLaboratoryStaff.setEmail(laboratoryStaff.getEmail());
        updatedLaboratoryStaff.setDepartment(laboratoryStaff.getDepartment());
        updatedLaboratoryStaff.setIsActive(laboratoryStaff.getIsActive());
        laboratoryStaffRepository.save(updatedLaboratoryStaff);
        return updatedLaboratoryStaff;
    }

    public void deleteLaboratoryStaff(Integer id){
        LaboratoryStaff deletedLaboratoryStaff = laboratoryStaffRepository.findByLaboratoryStaffId(id);
        deletedLaboratoryStaff.setIsActive(false);
        laboratoryStaffRepository.save(deletedLaboratoryStaff);
    }
    public LaboratoryStaff getLaboratoryStaffById(Integer id){
        return laboratoryStaffRepository.findByLaboratoryStaffId(id);
    }
    public List<LaboratoryStaff> getAllLaboratoryStaff(){
       return laboratoryStaffRepository.getAllStaff();
    }
    public LaboratoryStaff getLaboratoryStaffByName(String name){
        return laboratoryStaffRepository.findByLaboratoryStaffName(name);
    }
}
