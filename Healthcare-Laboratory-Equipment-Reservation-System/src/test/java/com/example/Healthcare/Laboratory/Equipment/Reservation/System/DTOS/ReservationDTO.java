package com.example.Healthcare.Laboratory.Equipment.Reservation.System.DTOS;

import com.example.Healthcare.Laboratory.Equipment.Reservation.System.Entities.Reservation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDTO {
    private Integer id;
    private LocalDate reservationDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private String purpose;
    private String status;

    public static ReservationDTO fromEntity(Reservation reservation) {
        ReservationDTO dto = new ReservationDTO();
        dto.setId(reservation.getId());
        dto.setStartTime(reservation.getStartTime());
        dto.setEndTime(reservation.getEndTime());
        dto.setPurpose(reservation.getPurpose());
        dto.setStatus(reservation.getStatus());
        return dto;
    }
}
