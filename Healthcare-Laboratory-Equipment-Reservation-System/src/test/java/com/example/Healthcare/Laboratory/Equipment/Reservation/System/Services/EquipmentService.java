package com.example.Healthcare.Laboratory.Equipment.Reservation.System.Services;

import com.example.Healthcare.Laboratory.Equipment.Reservation.System.DTOS.EquipmentResponseDTO;
import com.example.Healthcare.Laboratory.Equipment.Reservation.System.Entities.Equipment;
import com.example.Healthcare.Laboratory.Equipment.Reservation.System.Repositories.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentService {
    @Autowired
    private EquipmentRepository equipmentRepository;


    public EquipmentService(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }


    public EquipmentResponseDTO addEquipment(EquipmentResponseDTO dto) {

        Equipment equipment = new Equipment();

        equipment.setName(dto.getName());
        equipment.setSerialNumber(dto.getSerialNumber());
        equipment.setPurchaseDate(dto.getPurchaseDate());

        equipment.setStatus("Available");

        Equipment saved = equipmentRepository.save(equipment);

        return mapToDTO(saved);
    }


    public EquipmentResponseDTO updateEquipment(
            Integer id,
            EquipmentResponseDTO dto) {

        Equipment equipment = equipmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipment not found"));


        equipment.setName(dto.getName());
        equipment.setSerialNumber(dto.getSerialNumber());
        equipment.setPurchaseDate(dto.getPurchaseDate());


        Equipment updated = equipmentRepository.save(equipment);

        return mapToDTO(updated);
    }


    public void deleteEquipment(Integer id) {

        equipmentRepository.deleteById(id);
    }


    public EquipmentResponseDTO changeStatus(
            Integer id,
            String status) {

        Equipment equipment = equipmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipment not found"));


        equipment.setStatus(status);


        Equipment updated = equipmentRepository.save(equipment);

        return mapToDTO(updated);
    }

    public List<EquipmentResponseDTO> getAllEquipment() {

        return equipmentRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    public List<EquipmentResponseDTO> getAvailableEquipment() {

        return equipmentRepository.findByStatus("Available")
                .stream()
                .map(this::mapToDTO)
                .toList();
    }


    public EquipmentResponseDTO getEquipmentById(Integer id) {

        Equipment equipment = equipmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipment not found"));

        return mapToDTO(equipment);
    }
    private EquipmentResponseDTO mapToDTO(Equipment equipment) {
        EquipmentResponseDTO dto = new EquipmentResponseDTO();
        dto.setId(equipment.getId());
        dto.setName(equipment.getName());
        dto.setSerialNumber(equipment.getSerialNumber());
        dto.setStatus(equipment.getStatus());
        dto.setPurchaseDate(equipment.getPurchaseDate());
        if (equipment.getLaboratory() != null) {
            dto.setLaboratoryName(equipment.getLaboratory().getName());
        }
        return dto;
    }

}