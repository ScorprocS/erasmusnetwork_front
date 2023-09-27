package fr.mns.jee.erasmusnetwork.like;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import fr.mns.jee.erasmusnetwork.like.struct.LikedCommentStruct;
import fr.mns.jee.erasmusnetwork.like.struct.LikedPostStruct;
import fr.mns.jee.erasmusnetwork.like.struct.LikedUserStruct;

@FeignClient(value = "likesClient", url = "http://localhost:8082/api") 
public interface LikeRestClient {
    
//    User mapping
    @PostMapping(value="/user/like")
    String likeUser(@RequestBody LikedUserStruct likedUserStruct);

    @DeleteMapping(value="/user/unlike/{userId}")
    String unlikeUser(@PathVariable int userId);
    
    @GetMapping(value="/user/all")
    List<LikedUserStruct> findAllUsers();
    
    @GetMapping(value="/user/allLikedBy/{userId}")
    List<LikedUserStruct> findUserByUserId(@PathVariable int userId);
    
//    Post mapping
    @PostMapping(value="/post/like")
    String likePost(@RequestBody LikedPostStruct likedPostStruct);

    @DeleteMapping(value="/post/unlike/{postId}")
    String unlikePost(@PathVariable int postId);
    
    @GetMapping(value="/post/all")
	List<LikedPostStruct> findAllPosts();

    @GetMapping(value="/post/allLikedBy/{userId}")
	List<LikedPostStruct> findPostByUserId(@PathVariable int userId);

//    Comment mapping
    
    @PostMapping(value="/comment/like")
    String likeComment(@RequestBody LikedCommentStruct likedCommentStruct);

    @DeleteMapping(value="/comment/unlike/{commentId}")
    String unlikeComment(@PathVariable int commentId);
    
    @GetMapping(value="/comment/all")
	List<LikedCommentStruct> findAllComments();

    @GetMapping(value="/comment/allLikedBy/{userId}")
	List<LikedCommentStruct> findCommentByUserId(@PathVariable int userId);
}