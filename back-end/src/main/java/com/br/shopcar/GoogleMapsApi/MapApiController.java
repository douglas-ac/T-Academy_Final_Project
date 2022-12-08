package com.br.shopcar.GoogleMapsApi;

import com.br.shopcar.Dto.GET.AnnouncementDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/distance")
public class MapApiController {

    @Autowired
    MapApiService mapApiService;

    @GetMapping("/{idUser}")
    public ResponseEntity<List<AnnouncementDto>> findByAnnounce(@PathVariable("idUser") long idUser){
        List<Map.Entry<Integer, Integer>> entries = mapApiService.orderingAnnounces(idUser);
        return ResponseEntity.status(HttpStatus.OK).body(mapApiService.colletctAnnounces(entries));
    }

    @GetMapping("cars/{idUser}")
    public ResponseEntity<List<AnnouncementDto>> findByAnnounceCars(@PathVariable("idUser") long idUser){
        List<Map.Entry<Integer, Integer>> entries = mapApiService.orderingAnnouncesCars(idUser);
        return ResponseEntity.status(HttpStatus.OK).body(mapApiService.colletctAnnounces(entries));
    }

    @GetMapping("parts/{idUser}")
    public ResponseEntity<List<AnnouncementDto>> findByAnnounceParts(@PathVariable("idUser") long idUser){
        List<Map.Entry<Integer, Integer>> entries = mapApiService.orderingAnnouncesParts(idUser);
        return ResponseEntity.status(HttpStatus.OK).body(mapApiService.colletctAnnounces(entries));
    }
}
