package com.br.shopcar.Model.Announcement;

import com.br.shopcar.Dto.GET.AnnouncementDto;
import com.br.shopcar.Model.ProductModel;
import com.br.shopcar.Model.User.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Announcement {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    private Integer amount;
    @CreationTimestamp
    private LocalDateTime date;
    @Embedded
    private Adress adress;
    @OneToMany(mappedBy = "announcement")
    private List<Comment> comments;
    @ManyToOne
    private ProductModel product;

    public AnnouncementDto converter(){
        AnnouncementDto announcementDto = new AnnouncementDto();
        announcementDto.setId(this.getId());
        announcementDto.setUser(this.user.converterDtoSlim());
        announcementDto.setAmount(this.getAmount());
        announcementDto.setDate(this.getDate());
        announcementDto.setComments(this.getComments());
        announcementDto.setProduct(this.getProduct());
        return announcementDto;
    }

}
