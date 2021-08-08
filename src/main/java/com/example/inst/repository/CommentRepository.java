package com.example.inst.repository;

import com.example.inst.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Integer> {
    List<Comment> getByUserId(int userId);

    Comment getById(int id);

}
