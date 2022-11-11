package com.br.shopcar.Service;

import com.br.shopcar.Dto.GET.Comment.CommentDto;
import com.br.shopcar.Model.Announcement.Announcement;
import com.br.shopcar.Model.Announcement.Comment;
import com.br.shopcar.Model.User.User;
import com.br.shopcar.Repository.AnnouncementRepository;
import com.br.shopcar.Repository.CommentRepository;
import com.br.shopcar.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;
    @Autowired
    UserService userService;
    @Autowired
    AnnouncementService announcementService;

    public Comment findById(long id){
        Optional<Comment> obj = commentRepository.findById(id);
        Comment comment = obj.orElseThrow(()-> new EntityNotFoundException("Comment not found"));
        return comment;
    }

    public List<CommentDto> findByAnnounceId(long id){
        Optional<List<Comment>> obj = commentRepository.findByAnnouncementId(id);
        List<Comment> comment = obj.orElseThrow(()-> new EntityNotFoundException("Comment not found"));
        return comment.stream().map(Comment::convertToDto).collect(Collectors.toList());
    }

    @Transactional
    public CommentDto save(CommentDto commentDto){
        User userModel = userService.findByIdModel(commentDto.getUserId());
        Announcement announceModel = announcementService.findByIdModel(commentDto.getAnnounceId());
        Comment comment = commentDto.convertToModel(userModel, announceModel);
        commentRepository.save(comment);
        return comment.convertToDto();
    }

    @Transactional
    public void delete(long idComment){
        try {
            Optional<Comment> commentToDelete = commentRepository.findById(idComment);
            Comment comment = commentToDelete.orElseThrow(() -> new EntityNotFoundException("Comment not found"));
            commentRepository.delete(comment);
        } catch (Exception e){
            return; //exception handler
        }

    }

    public List<CommentDto> findAll() {
       return commentRepository.findAll().stream().map(Comment::convertToDto).collect(Collectors.toList());
    }

    public Comment findByIdModel(long id){
        Optional<Comment> byId = commentRepository.findById(id);
        Comment comment = byId.orElseThrow(() -> new EntityNotFoundException("Comment not found"));
        return comment;
    }
}
