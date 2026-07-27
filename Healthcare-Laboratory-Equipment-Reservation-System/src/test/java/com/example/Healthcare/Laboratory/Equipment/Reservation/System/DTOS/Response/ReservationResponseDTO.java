package com.example.Healthcare.Laboratory.Equipment.Reservation.System.DTOS.Response;

import com.example.Healthcare.Laboratory.Equipment.Reservation.System.Entities.Reservation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationResponseDTO {
    private Integer id;
    private LocalDate reservationDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private String purpose;
    private String status;
    private Integer staffId;
    private String staffName;


    public static ReservationResponseDTO fromEntity(Reservation reservation) {
        ReservationResponseDTO dto = new ReservationResponseDTO();
        dto.setId(reservation.getId());
        dto.setStartTime(reservation.getStartTime());
        dto.setEndTime(reservation.getEndTime());
        dto.setPurpose(reservation.getPurpose());
        dto.setStatus(reservation.getStatus());
        dto.setStaffId(dto.getStaffId());
        dto.setStaffName(dto.getStaffName());
        return dto;
    }
}
