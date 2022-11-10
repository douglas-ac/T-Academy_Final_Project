package com.br.shopcar.Service;

import com.br.shopcar.Dto.Comment.CommentDto;
import com.br.shopcar.Model.Announcement.Announcement;
import com.br.shopcar.Model.Announcement.Comment;
import com.br.shopcar.Model.User.User;
import com.br.shopcar.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;
    @Autowired
    UserService userService;
    @Autowired
    AnnouncementService announcementService;

    public CommentDto findByAnnounceId(Long id){
        Optional<Comment> obj = commentRepository.findByAnnouncementId(id);
        Comment comment = obj.orElseThrow(()-> new EntityNotFoundException("User not found"));
        return comment.convertToDto();
    }

    @Transactional
    public CommentDto save(CommentDto commentDto){
        User user = userService.findById(commentDto.getId()).convertToModel();
        Announcement announcement = announcementService.findById(commentDto.getId()).convertToModel();
        Comment comment = commentDto.convertToModel(user, announcement);
        return comment.convertToDto();
    }

    @Transactional
    public void delete(Long idComment){
        try {
            Optional<Comment> commentToDelete = commentRepository.findById(idComment);
            Comment comment = commentToDelete.orElseThrow(() -> new EntityNotFoundException("User not found"));
            commentRepository.delete(comment);
        } catch (Exception e){
            return; //exception handler
        }

    }
}
