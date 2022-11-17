package com.br.shopcar.Service;

import com.br.shopcar.Dto.GET.AnnouncementDto;
import com.br.shopcar.Dto.GET.Slim.UserDtoSlim;
import com.br.shopcar.Model.Announcement.Announcement;
import com.br.shopcar.Model.User.User;
import com.br.shopcar.Repository.AnnouncementRepository;
import com.br.shopcar.Service.AnnouncementService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityNotFoundException;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

@ExtendWith(SpringExtension.class)
public class AnnouncementServiceTest {
    private User user;
    private Announcement announcement;
    private Long validId;
    private Long invalidId;
    private List<Announcement> lista;

    @InjectMocks
    private AnnouncementService service;

    @Mock
    private AnnouncementRepository repository;


    @BeforeEach
    public void setup(){
        validId = 1L;
        invalidId = 2L;

        lista = new ArrayList<>();

        user = new User();
        user.setName("User");
        user.setId(1L);

        announcement = new Announcement();
        announcement.setUser(user);
        announcement.setAmount(10);
        announcement.setId(validId);


        Mockito.when(repository.save(any())).thenReturn(announcement);
        Mockito.when(repository.findAll()).thenReturn(lista);
        Mockito.when(repository.findById(validId)).thenReturn(Optional.of(announcement));
        Mockito.doThrow(EntityNotFoundException.class).when(repository).findById(invalidId);
        Mockito.doNothing().when(repository).delete(announcement);

    }

    @Test
    public void returnAdDTOOnSaving(){
        Assertions.assertNotNull(service.save(announcement.converter()));
        Mockito.verify(repository, Mockito.times(1)).save(any(Announcement.class));
    }

    @Test
    public void returnAdWhenFindingByValidId() {
        Assertions.assertNotNull(service.findByIdModel(validId));
        Mockito.verify(repository, Mockito.times(1)).findById(validId);
    }

    @Test
    public void throwEntityNotFoundExceptionWhenFindingByNonValidId() {
        Assertions.assertThrows(EntityNotFoundException.class, () -> {
            service.findByIdModel(invalidId);
        });
        Mockito.verify(repository, Mockito.times(1)).findById(invalidId);
    }

    @Test
    public void doesNothingWhenDeletingValidAd() {
        Assertions.assertDoesNotThrow(() -> {
            service.delete(validId);
        });

        Mockito.verify(repository, Mockito.times(1)).findById(validId);
        Mockito.verify(repository, Mockito.times(1)).delete(announcement);
    }

    @Test
    public void throwEntityNotFoundExceptionWhenDeletingNonValidAd() {
        Assertions.assertThrows(EntityNotFoundException.class, () -> {
            service.delete(invalidId);
        });
        Mockito.verify(repository, Mockito.never()).delete(any(Announcement.class));
    }

    @Test
    void returnListWhenFindingAll() {
        Assertions.assertNotNull(service.findAll());
        Mockito.verify(repository, Mockito.times(1)).findAll();
    }


}
