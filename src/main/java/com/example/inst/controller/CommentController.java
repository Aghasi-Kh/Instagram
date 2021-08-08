package com.example.inst.controller;

import com.example.inst.model.Comment;
import com.example.inst.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping
    public ResponseEntity getAll() {
        return ResponseEntity.ok(commentService.getAll());
    }

    @PostMapping(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@RequestBody Comment comment) {
        commentService.add(comment);
        return ResponseEntity.ok().build();
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@PathVariable int id, @Valid @RequestBody Comment comment) {
        comment.setId(id);
        commentService.update(comment);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping(path = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@PathVariable int id) {
        commentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
