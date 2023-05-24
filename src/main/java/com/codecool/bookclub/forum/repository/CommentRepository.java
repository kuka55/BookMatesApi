package com.codecool.bookclub.forum.repository;

import com.codecool.bookclub.forum.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByTopicIdOrderByCreationTimeDesc(long topicId);
}
