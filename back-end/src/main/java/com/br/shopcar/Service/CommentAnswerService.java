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
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentAnswerService {

    @Autowired
    CommentAnswerRepository commentAnswerRepository;
    @Autowired
    CommentService commentService;
    @Autowired
    UserService userService;

    public List<CommentAnswerDto> findByCommentId(long id){
        Optional<List<CommentAnswer>> obj = commentAnswerRepository.findByCommentId(id);
        List<CommentAnswer> commentAnswers = obj.orElseThrow(()-> new EntityNotFoundException("User not found"));
        return commentAnswers.stream().map(CommentAnswer::convertToDto).collect(Collectors.toList());
    }

    @Transactional
    public CommentAnswerDto save(CommentAnswerDto commentAnswerDto){
        User user = userService.findByIdModel(commentAnswerDto.getUser().getId());
        Comment comment = commentService.findByIdModel(commentAnswerDto.getComment().getId());
        CommentAnswer commentAnswer = commentAnswerDto.convertToModel(user, comment);
        commentAnswerRepository.save(commentAnswer);
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
