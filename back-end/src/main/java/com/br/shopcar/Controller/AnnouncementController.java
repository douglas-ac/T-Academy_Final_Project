package com.br.shopcar.Controller;

import com.br.shopcar.Dto.AnnouncementDto;
import com.br.shopcar.Service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/announce")
public class AnnouncementController {

    @Autowired
    AnnouncementService announcementService;

    @GetMapping
    public ResponseEntity<List<AnnouncementDto>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(announcementService.findAll());
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
    public ResponseEntity<Void> excluir(@PathVariable("idAnnounce") long idAnnounce){
        announcementService.delete(idAnnounce);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
