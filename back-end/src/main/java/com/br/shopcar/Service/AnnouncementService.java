package com.br.shopcar.Service;

import com.br.shopcar.Dto.GET.AnnouncementDto;
import com.br.shopcar.Model.Announcement.Announcement;
import com.br.shopcar.Repository.AnnouncementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnnouncementService {

    @Autowired
    AnnouncementRepository announcementRepository;

    public List<AnnouncementDto> findAll(){
        List<Announcement> allAnn = announcementRepository.findAll();
        //map to convert the announcements to Dtos
        return allAnn.stream().map(Announcement::converter).collect(Collectors.toList());
    }

    public AnnouncementDto findById(long id){
        Optional<Announcement> obj = announcementRepository.findById(id);
        //verifying the optional
        Announcement announcement = obj.orElseThrow(()-> new EntityNotFoundException("Announce not found"));
        return announcement.converter();
    }

    @Transactional
    public AnnouncementDto save(AnnouncementDto announcementDto){
        Announcement announcement = announcementDto.convertToModel();
        announcementRepository.save(announcement);
        return announcement.converter();
    }
    @Transactional
    public AnnouncementDto change(long idAnnounce, AnnouncementDto announcementDto){
        Optional<Announcement> annToChange = announcementRepository.findById(idAnnounce);

        //variable to store the object from database
        Announcement announcement = annToChange.orElseThrow(() -> new EntityNotFoundException("User not found"));

        //Dto received converted to model to change attributes
        Announcement dtoToChangeModel = announcementDto.convertToModel();

        //setting the changes
        announcement.setAdress(dtoToChangeModel.getAdress());
        announcement.setAmount(dtoToChangeModel.getAmount());
        announcement.setDate(dtoToChangeModel.getDate());

        //saving changes
        announcementRepository.save(announcement);

        //return DTO
        return announcement.converter();

    }

    @Transactional
    public void delete(long idAnn){
        try {
            //searching the object in the database
            Optional<Announcement> annToDelete = announcementRepository.findById(idAnn);
            //if founded -> delete else-> exception
            Announcement announcement = annToDelete.orElseThrow(() -> new EntityNotFoundException("User not found"));
            announcementRepository.delete(announcement);
        } catch (Exception e){
            return; //exception handler to develop
        }

    }
}
