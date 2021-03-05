package fr.library.emprunt.controller;


import fr.library.emprunt.dto.ReservationDTO;
import fr.library.emprunt.dto.ReservationProlRequest;
import fr.library.emprunt.dto.ReservationRequest;
import fr.library.emprunt.mapper.ReservationMapper;
import fr.library.emprunt.model.ReservationEntity;
import fr.library.emprunt.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// suivre reservation+mettre a jour reservation
@RestController
@RequestMapping("reservations")
public class ReservationController {
    private final ReservationService reservationService;
    private final ReservationMapper reservationMapper;

    public ReservationController(ReservationService reservationService, ReservationMapper reservationMapper) {
        this.reservationService = reservationService;
        this.reservationMapper = reservationMapper;
    }

    @GetMapping("/")
    public List<ReservationDTO> getAll() {
        List<ReservationEntity> entities = reservationService.findAll();
        return reservationMapper.toDTOs(entities);
    }

    @GetMapping("/{id}")
    public ReservationDTO getOne(@PathVariable("id") Long reservationId) {
        ReservationEntity entity = reservationService.getOne(reservationId);
        return reservationMapper.toDTO(entity);
    }

    @PostMapping("/")
    public ReservationDTO create(@RequestBody ReservationRequest request) {
        ReservationEntity entity = reservationService.save(reservationMapper.toEntity(request));
        return reservationMapper.toDTO(entity);
    }

    @PatchMapping("/{id}")
    public ReservationDTO updateById(@PathVariable("id") Long reservationId, @RequestBody RetourReservationRequest request) {
        ReservationEntity entity = reservationService.getOne(reservationId);
        entity.setDtRetour(request.getDateRetour());
        reservationService.save(entity);
        return reservationMapper.toDTO(entity);
    }

    @PostMapping("/prolonger/{id}")
    public ReservationDTO prolongationById(@PathVariable("id") Long reservationId) {
        return reservationMapper.toDTO(reservationService.prolonger(reservationId));
    }

}
