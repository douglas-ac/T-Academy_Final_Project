package com.br.shopcar.Service;

import com.br.shopcar.Dto.GET.Comment.CommentAnswerDto;
import com.br.shopcar.Model.Announcement.Comment;
import com.br.shopcar.Model.Announcement.CommentAnswer;
import com.br.shopcar.Model.User.User;
import com.br.shopcar.Repository.CommentAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class CommentAnswerService {

    @Autowired
    CommentAnswerRepository commentAnswerRepository;
    @Autowired
    CommentService commentService;
    @Autowired
    UserService userService;

    public CommentAnswerDto findByCommentId(long id){
        Optional<CommentAnswer> obj = commentAnswerRepository.findByCommentId(id);
        CommentAnswer comment = obj.orElseThrow(()-> new EntityNotFoundException("User not found"));
        return comment.convertToDto();
    }

    @Transactional
    public CommentAnswerDto save(CommentAnswerDto commentAnswerDto){
        User user = userService.findById(commentAnswerDto.getUserId()).convertToModel();
        Comment comment = commentService.findById(commentAnswerDto.getCommentId());
        CommentAnswer commentAnswer = commentAnswerDto.convertToModel(user, comment);
        return commentAnswer.convertToDto();
    }

    @Transactional
    public void delete(long idAnswer){
        try {
            Optional<CommentAnswer> answerToDelete = commentAnswerRepository.findById(idAnswer);
            CommentAnswer answer = answerToDelete.orElseThrow(() -> new EntityNotFoundException("User not found"));
            commentAnswerRepository.delete(answer);
        } catch (Exception e){
            return; //exception handler
        }

    }
}
