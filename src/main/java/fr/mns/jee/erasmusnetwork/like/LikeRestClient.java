package fr.mns.jee.erasmusnetwork.like;

import fr.mns.jee.erasmusnetwork.like.struct.LikedCommentStruct;
import fr.mns.jee.erasmusnetwork.like.struct.LikedPostStruct;
import fr.mns.jee.erasmusnetwork.like.struct.LikedUserStruct;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "likesClient", url = "http://localhost:8082/api") 
public interface LikeRestClient {
    @PostMapping(value="/user/like")
    String likeUser(@RequestBody LikedUserStruct likedUserStruct);

    @DeleteMapping(value="/user/unlike")
    String unlikeUser(@RequestHeader int entityId);

    @PostMapping(value="/post/like")
    String likePost(@RequestBody LikedPostStruct likedPostStruct);

    @DeleteMapping(value="/post/unlike")
    String unlikePost(@RequestHeader int entityId);

    @PostMapping(value="/comment/like")
    String likeComment(@RequestBody LikedCommentStruct likedCommentStruct);

    @DeleteMapping(value="/comment/unlike")
    String unlikeComment(@RequestHeader int entityId);
}