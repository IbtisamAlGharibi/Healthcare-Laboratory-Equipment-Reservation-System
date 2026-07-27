package com.example.Healthcare.Laboratory.Equipment.Reservation.System.Services;

import com.example.Healthcare.Laboratory.Equipment.Reservation.System.DTOS.Request.ReservationRequestDTO;
import com.example.Healthcare.Laboratory.Equipment.Reservation.System.DTOS.Response.ReservationResponseDTO;
import com.example.Healthcare.Laboratory.Equipment.Reservation.System.Entities.LaboratoryStaff;
import com.example.Healthcare.Laboratory.Equipment.Reservation.System.Entities.Reservation;
import com.example.Healthcare.Laboratory.Equipment.Reservation.System.Repositories.LaboratoryStaffRepository;
import com.example.Healthcare.Laboratory.Equipment.Reservation.System.Repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    ReservationRepository  reservationRepository;
    LaboratoryStaffRepository   laboratoryStaffRepository;
    @Autowired
    public ReservationService(ReservationRepository reservationRepository, LaboratoryStaffRepository   laboratoryStaffRepository) {
        this.reservationRepository = reservationRepository;
        this.laboratoryStaffRepository = laboratoryStaffRepository;
    }

    public ReservationResponseDTO createReservation(ReservationRequestDTO reservationRequestDTO, Integer staffId) {
        LaboratoryStaff laboratoryStaff = laboratoryStaffRepository.findByLaboratoryStaffId(staffId);
        Reservation newReservation = reservationRequestDTO.toEntity();
        newReservation.setLaboratoryStaff(laboratoryStaff);
        newReservation.setStatus("Pending");
        Reservation savedReservation = reservationRepository.save(newReservation);
        return ReservationResponseDTO.fromEntity(savedReservation);
    }
    public ReservationResponseDTO approveReservation(Integer staffId) {
        Reservation reservation = reservationRepository.findByLaboratoryStaffId(staffId);
        reservation.setStatus("Approved");
        Reservation savedReservation = reservationRepository.save(reservation);
        return ReservationResponseDTO.fromEntity(savedReservation);
    }
    public Reservation cancelReservation(Reservation reservation, Integer staffId) {
        Reservation newReservation = reservationRepository.findByLaboratoryStaffId(staffId);
        newReservation.setStatus("Cancelled");
        return reservationRepository.save(newReservation);
    }
    public Reservation getReservation(Integer reservationId) {
        return reservationRepository.findReservationById(reservationId);
    }
    public List<Reservation> getAllReservations() {
        return reservationRepository.getAllReservation();
    }

    public List<Reservation> getReservationsByStaff(Integer staffId) {
        return reservationRepository.findReservationsByLaboratoryStaffId(staffId);
    }

    public void deleteReservation(Integer id){
       Reservation deletedReservation = reservationRepository.findReservationById(id);
        deletedReservation.setIsActive(false);
        reservationRepository.save(deletedReservation);
    }
}
