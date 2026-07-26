package com.example.Healthcare.Laboratory.Equipment.Reservation.System.Services;

import com.example.Healthcare.Laboratory.Equipment.Reservation.System.DTOS.LaboratoryResponseDTO;
import com.example.Healthcare.Laboratory.Equipment.Reservation.System.Entities.Laboratory;
import com.example.Healthcare.Laboratory.Equipment.Reservation.System.Repositories.LaboratoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaboratoryService {
    @Autowired
    private LaboratoryRepository laboratoryRepository;


    public LaboratoryService(LaboratoryRepository laboratoryRepository) {
        this.laboratoryRepository = laboratoryRepository;
    }

    public LaboratoryResponseDTO addLaboratory(LaboratoryResponseDTO dto) {

        Laboratory laboratory = new Laboratory();

        laboratory.setName(dto.getName());
        laboratory.setLocation(dto.getLocation());
        laboratory.setDescription(dto.getDescription());

        Laboratory saved = laboratoryRepository.save(laboratory);

        return mapToDTO(saved);
    }

    public LaboratoryResponseDTO updateLaboratory(
            Integer id,
            LaboratoryResponseDTO dto) {

        Laboratory laboratory = laboratoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Laboratory not found"));


        laboratory.setName(dto.getName());
        laboratory.setLocation(dto.getLocation());
        laboratory.setDescription(dto.getDescription());


        Laboratory updated = laboratoryRepository.save(laboratory);

        return mapToDTO(updated);
    }


    public void deleteLaboratory(Integer id) {

        laboratoryRepository.deleteById(id);
    }


    public List<LaboratoryResponseDTO> getAllLaboratories() {

        return laboratoryRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }


    public LaboratoryResponseDTO getLaboratoryById(Integer id) {

        Laboratory laboratory = laboratoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Laboratory not found"));

        return mapToDTO(laboratory);
    }


    private LaboratoryResponseDTO mapToDTO(Laboratory laboratory) {
        LaboratoryResponseDTO dto = new LaboratoryResponseDTO();
        dto.setId(laboratory.getId());
        dto.setName(laboratory.getName());
        dto.setLocation(laboratory.getLocation());
        dto.setDescription(laboratory.getDescription());
        return dto;
    }

}

