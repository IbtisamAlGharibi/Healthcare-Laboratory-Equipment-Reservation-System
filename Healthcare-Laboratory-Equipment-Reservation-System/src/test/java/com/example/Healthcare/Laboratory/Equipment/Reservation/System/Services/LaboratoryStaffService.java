package com.example.Healthcare.Laboratory.Equipment.Reservation.System.Services;

import com.example.Healthcare.Laboratory.Equipment.Reservation.System.DTOS.Request.LaboratoryStaffRequestDTO;
import com.example.Healthcare.Laboratory.Equipment.Reservation.System.DTOS.Response.LaboratoryStaffResponseDTO;
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

    public LaboratoryStaffResponseDTO addLaboratoryStaff(LaboratoryStaffRequestDTO laboratoryStaffRequestDTO) {
        LaboratoryStaff newLaboratoryStaff = laboratoryStaffRequestDTO.toEntity();
        newLaboratoryStaff.setIsActive(true);
        LaboratoryStaff savedLaboratoryStaff = laboratoryStaffRepository.save(newLaboratoryStaff);
        return LaboratoryStaffResponseDTO.fromEntity(savedLaboratoryStaff);
    }

    public LaboratoryStaffResponseDTO updateLaboratoryStaff(Integer id, LaboratoryStaffRequestDTO laboratoryStaffRequestDTO) {
        LaboratoryStaff updatedLaboratoryStaff = laboratoryStaffRepository.findByLaboratoryStaffId(id);
        updatedLaboratoryStaff.setName(laboratoryStaffRequestDTO.getName());
        updatedLaboratoryStaff.setPhone(laboratoryStaffRequestDTO.getPhone());
        updatedLaboratoryStaff.setEmail(laboratoryStaffRequestDTO.getEmail());
        updatedLaboratoryStaff.setDepartment(laboratoryStaffRequestDTO.getDepartment());
        LaboratoryStaff savedLaboratoryStaff = laboratoryStaffRepository.save(updatedLaboratoryStaff);
        return LaboratoryStaffResponseDTO.fromEntity(savedLaboratoryStaff);
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
    public List<LaboratoryStaff> getLaboratoryStaffByDepartment(String department){
       return laboratoryStaffRepository.findByDepartment(department);
    }
}
