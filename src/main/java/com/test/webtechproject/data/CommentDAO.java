package com.test.webtechproject.data;

import com.test.webtechproject.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface CommentDAO extends JpaRepository<Comment, Long> {

}
