package com.br.shopcar.Controller;

import com.br.shopcar.Dto.GET.Comment.CommentAnswerDto;
import com.br.shopcar.Dto.GET.Comment.CommentDto;
import com.br.shopcar.Service.CommentAnswerService;
import com.br.shopcar.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/comment/answer")
public class CommentAnswerController {

    @Autowired
    CommentAnswerService commentAnswerService;

    @GetMapping("/{idComment}")
    public ResponseEntity<List<CommentAnswerDto>> findByAnnounce(@PathVariable("idComment") long idComment){
        return ResponseEntity.status(HttpStatus.OK).body(commentAnswerService.findByCommentId(idComment));
    }

    @PostMapping
    public ResponseEntity<CommentAnswerDto> save(@RequestBody CommentAnswerDto commentAnswerDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(commentAnswerService.save(commentAnswerDto));
    }

    @DeleteMapping("/{idCommentAnswer}")
    public ResponseEntity<Void> delete(@PathVariable("idCommentAnswer") long idCommentAnswer){
        commentAnswerService.delete(idCommentAnswer);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
