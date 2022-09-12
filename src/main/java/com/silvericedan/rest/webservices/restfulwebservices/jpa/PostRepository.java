package com.silvericedan.rest.webservices.restfulwebservices.jpa;

import com.silvericedan.rest.webservices.restfulwebservices.Post;
import com.silvericedan.rest.webservices.restfulwebservices.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
