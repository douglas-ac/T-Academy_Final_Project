package com.br.shopcar.Dto.GET.Slim;

import com.br.shopcar.Dto.GET.Comment.CommentDto;
import com.br.shopcar.Model.Announcement.Address;
import com.br.shopcar.Model.Announcement.Announcement;
import com.br.shopcar.Model.Announcement.Status;
import com.br.shopcar.Model.ProductModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Data
public class AnnouncementSlim {

    private long id;

    @NotBlank
    private Integer amount;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private UserDtoSlim user;

    private LocalDateTime date;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<CommentDto> comments = new ArrayList<>();

    @NotBlank
    private ProductModel product;
    private Address address;
    private Status status;

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
        announcement.setAddress(this.getAddress());
        announcement.setStatus(this.getStatus());
        return announcement;
    }

}
