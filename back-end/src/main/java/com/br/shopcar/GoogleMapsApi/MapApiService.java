package com.br.shopcar.GoogleMapsApi;

import com.br.shopcar.Dto.GET.AnnouncementDto;
import com.br.shopcar.Dto.GET.Slim.AnnouncementSlim;
import com.br.shopcar.Model.Announcement.Announcement;
import com.br.shopcar.Model.User.User;
import com.br.shopcar.Repository.AnnouncementRepository;
import com.br.shopcar.Service.AnnouncementService;
import com.br.shopcar.Service.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MapApiService {
    @Autowired
    UserService userService;
    @Autowired
    AnnouncementService announcementService;
    @Autowired
    AnnouncementRepository announcementRepository;

    public int findDistanceForUserAndAnnouce(long idUser, long idAnnouce ){
        User user = userService.findByIdModel(idUser);
        Announcement announcement = announcementService.findByIdModel(idAnnouce);
        String adressUser = user.getAddress().getLocalidade() + "," +
                user.getAddress().getUf() + ",BR";
        String adressAnnounce = announcement.getAddress().getLocalidade() + "," +
                announcement.getAddress().getUf() + ",BR";
        String distance = RequestMapApi.calculateDistance(adressUser, adressAnnounce);
        return filterDistance(distance);
    }

    public int findDistanceForPlaceAndAnnouce(String place, long idAnnouce ){
        Announcement announcement = announcementService.findByIdModel(idAnnouce);
        String adressAnnounce = announcement.getAddress().getLocalidade() + "," +
                announcement.getAddress().getUf() + ",BR";
        String distance = RequestMapApi.calculateDistance(place, adressAnnounce);
        return filterDistance(distance);
    }

    public int filterDistance(String distance){
        MapApiResponseClass mapApiResponseClass = new Gson().fromJson(distance, MapApiResponseClass.class);
        return (mapApiResponseClass.getRows().get(0).getElements().get(0).getDistance().value) / 1000;
    }

    public List<Map.Entry<Integer, Integer>> orderingAnnounces(long idUser){
        List<AnnouncementSlim> all = announcementService.findAll();
        HashMap<Integer, Integer> allDistances = new HashMap<>();
        all.forEach( a -> {
            int distanceForUserAndAnnouce = findDistanceForUserAndAnnouce(idUser, a.getId());
            allDistances.put((int) a.getId(), distanceForUserAndAnnouce);
        });
        return allDistances.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList());
    }

    public List<Map.Entry<Integer, Integer>> orderingAnnouncesCars(long idUser){
        List<Announcement> all = announcementRepository.findAllAnnouncesCarList();
        HashMap<Integer, Integer> allDistances = new HashMap<>();
        all.forEach( a -> {
            int distanceForUserAndAnnouce = findDistanceForUserAndAnnouce(idUser, a.getId());
            allDistances.put((int) a.getId(), distanceForUserAndAnnouce);
        });
        return allDistances.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList());
    }

    public List<Map.Entry<Integer, Integer>> orderingAnnouncesParts(long idUser){
        List<Announcement> all = announcementRepository.findAllAnnouncesPartList();
        HashMap<Integer, Integer> allDistances = new HashMap<>();
        all.forEach( a -> {
            int distanceForUserAndAnnouce = findDistanceForUserAndAnnouce(idUser, a.getId());
            allDistances.put((int) a.getId(), distanceForUserAndAnnouce);
        });
        return allDistances.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList());
    }

    public Page<AnnouncementDto> colletctAnnounces(List<Map.Entry<Integer, Integer>> map, Pageable pageable){
        List<AnnouncementDto> listOfAnnounces = new ArrayList<>();
        map.forEach( m -> {
            AnnouncementDto byId = announcementService.findById(Long.valueOf(m.getKey()));
            listOfAnnounces.add(byId);
        });
        return new PageImpl<AnnouncementDto> (listOfAnnounces, pageable, listOfAnnounces.size());
    }
}
