package com.br.shopcar.tests;

import com.br.shopcar.Dto.GET.AnnouncementDto;
import com.br.shopcar.Model.Announcement.Adress;
import com.br.shopcar.Model.Announcement.Announcement;
import com.br.shopcar.Model.User.User;

import java.time.LocalDateTime;
public class FactoryAnnouncement {
    public static Announcement createAnnouncement() {
        Adress adress = new Adress();
        adress.setCep("89030140");
        adress.setLogradouro("Rua Clara Persuhn");
        adress.setComplemento("Casa");
        adress.setBairro("Itoupava Seca");
        adress.setLocalidade("Blumenau");
        adress.setUf("SC");
        adress.setDdd("47");

        User user = new User();
        user.setId(1L);
        user.setName("Deide Costa");
        user.setEmail("deidecosta@email.com");
        user.setBirthDate("29/02/1969");

        LocalDateTime date = LocalDateTime.now();

        Announcement announcement = new Announcement();
        announcement.setId(1L);
        announcement.setAdress(adress);
        announcement.setUser(user);
        announcement.setDate(date);
        announcement.setAmount(1);

        return announcement;
    }

    public static Announcement createAnnouncementNullId() {
        Adress adress = new Adress();
        adress.setCep("89030140");
        adress.setLogradouro("Rua Clara Persuhn");
        adress.setComplemento("Casa");
        adress.setBairro("Itoupava Seca");
        adress.setLocalidade("Blumenau");
        adress.setUf("SC");
        adress.setDdd("47");

        User user = new User();
        user.setId(1L);
        user.setName("Deide Costa");
        user.setEmail("deidecosta@email.com");
        user.setBirthDate("29/02/1969");

        LocalDateTime date = LocalDateTime.now();

        Announcement announcement = new Announcement();
        announcement.setId(1L);
        announcement.setAdress(adress);
        announcement.setUser(user);
        announcement.setDate(date);
        announcement.setAmount(1);

        return announcement;
    }

    public static AnnouncementDto createAnnouncementDto(){
        Announcement a = createAnnouncement();
        return a.converter();
    }
}
