package fr.library.emprunt.controller;


import fr.library.emprunt.dto.ReservationDTO;
import fr.library.emprunt.mapper.ReservationMapper;
import fr.library.emprunt.model.ReservationEntity;
import fr.library.emprunt.service.ReservationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
// suivre reservation+mettre a jour reservation
@RestController
@RequestMapping("reservation")
public class ReservationController {
    private final ReservationService reservationService;
    private final ReservationMapper reservationMapper;

    public ReservationController(ReservationService reservationService, ReservationMapper reservationMapper) {
        this.reservationService = reservationService;
        this.reservationMapper = reservationMapper;
    }

    @GetMapping("/liste")
    public List<ReservationDTO> getAll() {
        List<ReservationEntity> entities = reservationService.findAll();
        return reservationMapper.toDTOs(entities);
    }
}
