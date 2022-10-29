package com.tabdaul.tabanewsapp.repositories;

import com.tabdaul.tabanewsapp.Entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author MOSAED ALOTAIBI (MASAAD)
 * @created 10/30/2022 at 01:53
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
