package com.br.shopcar.Dto.GET;

import com.br.shopcar.Dto.GET.Comment.CommentDto;
import com.br.shopcar.Dto.GET.Slim.UserDtoSlim;
import com.br.shopcar.Model.Announcement.Address;
import com.br.shopcar.Model.Announcement.Announcement;
import com.br.shopcar.Model.Announcement.Status;
import com.br.shopcar.Model.ProductModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AnnouncementDto {

    private long id;
    @NotBlank
    private UserDtoSlim user;
    @NotBlank
    private Integer amount;
    private LocalDateTime date;
    private List<CommentDto> comments = new ArrayList<>();
    @NotBlank
    private ProductModel product;
    private Address address;
    private Status status = Status.AVAILABLE;
    private Address adress;

    public Announcement convertToModel(){
        Announcement announcement = new Announcement();
        announcement.setId(this.getId());
        announcement.setUser(this.getUser().convertToModel());
        announcement.setAmount(this.getAmount());
        announcement.setDate(this.getDate());
        announcement.setComments(this.getComments().stream()
                .map(CommentDto::convertToModel)
                .collect(Collectors.toList()));
        announcement.setProduct(this.getProduct());
        announcement.setStatus(this.getStatus());
        announcement.setAddress(this.getAddress());
        return announcement;
    }
}
