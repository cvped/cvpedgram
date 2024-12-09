package com.cvpedgram.post.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cvpedgram.post.domain.Post;

// 한 행의 정보를 저장하기 위해서 만든다
public interface PostRepository extends JpaRepository<Post,Integer> {


}
