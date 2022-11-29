package com.br.shopcar.Controller;

import com.br.shopcar.Dto.GET.AnnouncementDto;
import com.br.shopcar.Service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/announce")
public class AnnouncementController {

    @Autowired
    AnnouncementService announcementService;

    @GetMapping
    public ResponseEntity<Page<AnnouncementDto>> findAll(@PageableDefault(sort = "id",
            direction = Sort.Direction.ASC,
            page = 0,
            size = 10) Pageable page){
        return ResponseEntity.status(HttpStatus.OK).body(announcementService.findAll(page));
    }

    @GetMapping("/cars")
    public ResponseEntity<Page<AnnouncementDto>> findCars(@PageableDefault(sort = "id",
            direction = Sort.Direction.ASC,
            page = 0,
            size = 10) Pageable page){
        return ResponseEntity.status(HttpStatus.OK).body(announcementService.findAllCars(page));
    }

    @GetMapping("/parts")
    public ResponseEntity<Page<AnnouncementDto>> findParts(@PageableDefault(sort = "id",
            direction = Sort.Direction.ASC,
            page = 0,
            size = 10) Pageable page){
        return ResponseEntity.status(HttpStatus.OK).body(announcementService.findAllParts(page));
    }

    @GetMapping("/{idAnnounce}")
    public ResponseEntity<AnnouncementDto> findById(@PathVariable("idAnnounce") long idAnnounce){
        return ResponseEntity.status(HttpStatus.OK).body(announcementService.findById(idAnnounce));
    }

    @PostMapping
    public ResponseEntity<AnnouncementDto> save(@RequestBody AnnouncementDto announcementDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(announcementService.save(announcementDto));
    }

    @PutMapping("/{idAnnounce}")
    public ResponseEntity<AnnouncementDto> change(@PathVariable("idAnnounce") long idAnnounce,
                                          @RequestBody AnnouncementDto announcementDto){
        return ResponseEntity.status(HttpStatus.OK).body(announcementService.change(idAnnounce, announcementDto));
    }

    @DeleteMapping("/{idAnnounce}")
    public ResponseEntity<java.lang.Object> delete(@PathVariable("idAnnounce") long idAnnounce){
        announcementService.delete(idAnnounce);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
