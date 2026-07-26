package com.example.Healthcare.Laboratory.Equipment.Reservation.System.Services;

import com.example.Healthcare.Laboratory.Equipment.Reservation.System.Entities.LaboratoryStaff;
import com.example.Healthcare.Laboratory.Equipment.Reservation.System.Entities.Reservation;
import com.example.Healthcare.Laboratory.Equipment.Reservation.System.Repositories.LaboratoryStaffRepository;
import com.example.Healthcare.Laboratory.Equipment.Reservation.System.Repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    ReservationRepository  reservationRepository;
    LaboratoryStaffRepository   laboratoryStaffRepository;
    @Autowired
    public ReservationService(ReservationRepository reservationRepository, LaboratoryStaffRepository   laboratoryStaffRepository) {
        this.reservationRepository = reservationRepository;
        this.laboratoryStaffRepository = laboratoryStaffRepository;
    }

    public Reservation createReservation(Reservation reservation, Integer staffId) {
        LaboratoryStaff laboratoryStaff = laboratoryStaffRepository.findByLaboratoryStaffId(staffId);
        Reservation newReservation = new Reservation();
       newReservation.setLaboratoryStaff(laboratoryStaff);
       newReservation.setReservationDate(reservation.getReservationDate());
       newReservation.setStatus(reservation.getStatus());
       newReservation.setStartTime(reservation.getStartTime());
       newReservation.setEndTime(reservation.getEndTime());
       newReservation.setPurpose(reservation.getPurpose());
       return reservationRepository.save(newReservation);
    }
    public Reservation approveReservation(Reservation reservation, Integer staffId) {
        Reservation newReservation = reservationRepository.findByLaboratoryStaffId(staffId);
        newReservation.setStatus("Approved");
        return reservationRepository.save(newReservation);
    }
}
