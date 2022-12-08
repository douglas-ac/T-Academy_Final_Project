package com.br.shopcar.Controller;

import com.br.shopcar.Dto.GET.Comment.CommentAnswerDto;
import com.br.shopcar.Service.CommentAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/comment/answer")
public class CommentAnswerController {

    @Autowired
    CommentAnswerService commentAnswerService;

    @GetMapping("/{idComment}")
    public ResponseEntity<java.lang.Object> findByAnnounce(@PathVariable("idComment") long idComment){
        return ResponseEntity.status(HttpStatus.OK).body(commentAnswerService.findByCommentId(idComment));
    }

    @PostMapping
    public ResponseEntity<CommentAnswerDto> save(@RequestBody CommentAnswerDto commentAnswerDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(commentAnswerService.save(commentAnswerDto));
    }

    @DeleteMapping("/{idCommentAnswer}")
    public ResponseEntity<java.lang.Object> delete(@PathVariable("idCommentAnswer") long idCommentAnswer){
        commentAnswerService.delete(idCommentAnswer);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
