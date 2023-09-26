package fr.mns.jee.erasmusnetwork.like;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "likesClient", url = "http://localhost:8080/") public interface LikeRestClient {
    @PostMapping(value="/user/like")
    String likeUser(@RequestBody int entityId, int userId, int likedUserId);

    @PostMapping(value="/user/unlike")
    String unlikeUser(@RequestBody int entityId, int userId, int likedUserId);

    @PostMapping(value="/post/like")
    String likePost(@RequestBody int entityId, int userId, int likedPostId);

    @PostMapping(value="/post/unlike")
    String unlikePost(@RequestBody int entityId, int userId, int likedPostId);

    @PostMapping(value="/comment/like")
    String likeComment(@RequestBody int entityId, int userId, int likedCommentId);

    @PostMapping(value="/comment/unlike")
    String unlikeComment(@RequestBody int entityId, int userId, int likedCommentId);
}