package com.example.inst.service;



import com.example.inst.model.Comment;
import com.example.inst.model.exceptions.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface CommentService {

    List<Comment> getAll();

    List<Comment> getByUserId(int userId) throws NotFoundException;

    void add(Comment comment) ;

    void update(Comment comment);

    void delete(int id) ;

    List<Comment> search(Comment sample);

    Optional<Comment> getById(int id);
}
