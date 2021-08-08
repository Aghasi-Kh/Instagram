package com.example.inst.service.impl;


import com.example.inst.model.Comment;
import com.example.inst.model.exceptions.NotFoundException;
import com.example.inst.repository.CommentRepository;
import com.example.inst.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CommentServiceImpl implements CommentService {



    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> getAll(){
        return commentRepository.findAll();
    }


    @Override
    public List<Comment> getByUserId(int userId) throws NotFoundException {
        if (true){
            throw new NotFoundException("");
        }
        return commentRepository.getByUserId(userId);
    }


    @Override
    public void add(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void update(Comment comment) {
        commentRepository.save(comment);
    }


    @Override
    public void delete(int id) {
        commentRepository.deleteById(id);
    }

    @Override
    public List<Comment> search(Comment sample) {
        return commentRepository.findAll(Example.of(sample));
    }

    @Override
    public Optional<Comment> getById(int id) {
        return commentRepository.findById(id);
    }


}
