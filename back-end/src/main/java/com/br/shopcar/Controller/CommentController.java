package com.br.shopcar.Controller;

import com.br.shopcar.Dto.GET.Comment.CommentDto;
import com.br.shopcar.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping("/{idAnnounce}")
    public ResponseEntity<List<CommentDto>> findByAnnounce(@PathVariable("idAnnounce") long idAnnounce){
        return ResponseEntity.status(HttpStatus.OK).body(commentService.findByAnnounceId(idAnnounce));
    }

    @PostMapping
    public ResponseEntity<CommentDto> save(@RequestBody CommentDto commentDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(commentService.save(commentDto));
    }

    @DeleteMapping("/{idComment}")
    public ResponseEntity<Void> delete(@PathVariable("idComment") long idComment){
        commentService.delete(idComment);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
