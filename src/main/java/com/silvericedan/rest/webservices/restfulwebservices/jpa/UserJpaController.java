package com.silvericedan.rest.webservices.restfulwebservices.jpa;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.silvericedan.rest.webservices.restfulwebservices.Post;
import com.silvericedan.rest.webservices.restfulwebservices.user.User;
import com.silvericedan.rest.webservices.restfulwebservices.user.UserNotFoundException;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserJpaController {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PostRepository postRepository;

  @GetMapping("/jpa/users")
  public List<User> retrieveAllUsers(){
    return userRepository.findAll();
  }

  @GetMapping("/jpa/users/{id}")
  public EntityModel<User> retrieveUser(@PathVariable int id){
    Optional<User> user = userRepository.findById(id);
    if(user.isEmpty())
      throw new UserNotFoundException("id-"+id);

    EntityModel<User> model = EntityModel.of(user.get());
    WebMvcLinkBuilder linkToUsers = linkTo(methodOn(this.getClass()).retrieveAllUsers());
    model.add(linkToUsers.withRel("all-users"));
    return model;
  }

  @DeleteMapping("/jpa/users/{id}")
  public void deleteUser(@PathVariable int id){
    if(!userRepository.existsById(id)){
      throw new UserNotFoundException("id-"+id);
    }
   userRepository.deleteById(id);
  }

  @GetMapping("/jpa/users/{id}/posts")
  public List<Post> retrievePostsForUser(@PathVariable int id){
    Optional<User> user = userRepository.findById(id);
    if(user.isEmpty())
      throw new UserNotFoundException("id-"+id);
    return user.get().getPosts();
  }

  //input - details of user
  //output - CREATED & Return the created URI
  @PostMapping("/jpa/users")
  public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
    User savedUser = userRepository.save(user);

    URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(savedUser.getId()).toUri();
    return ResponseEntity.created(location).build();
  }

  @PostMapping("/jpa/users/{id}/posts")
  public ResponseEntity<Object> createPostsForUser(@PathVariable int id,@Valid @RequestBody Post post){
    Optional<User> user = userRepository.findById(id);
    if(user.isEmpty())
      throw new UserNotFoundException("id-"+id);
    post.setUser(user.get());
    Post savedPost = postRepository.save(post);

    URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(savedPost.getId()).toUri();
    return ResponseEntity.created(location).build();
  }
}
