package fr.mns.jee.erasmusnetwork.like.service;

import fr.mns.jee.erasmusnetwork.like.LikeRestClient;
import fr.mns.jee.erasmusnetwork.like.struct.LikedUserStruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class LikeRestClientService {
    @Autowired
    private LikeRestClient likeRestClient;

    public String likeUser(int entityId, int userId, int likedUserId) {
        LikedUserStruct likedUserStruct = new LikedUserStruct();
        return likeRestClient.likeUser(entityId, userId, likedUserId);
    }

    public String unlikeUser(int entityId, int userId, int likedUserId) {
        return likeRestClient.unlikeUser(entityId);
    }

    public String likePost(int entityId, int userId, int likedPostId) {
        return likeRestClient.likePost(entityId, userId, likedPostId);
    }

    public String unlikePost(int entityId, int userId, int likedPostId) {
        return likeRestClient.unlikePost(entityId);
    }

    public String likeComment(int entityId, int userId, int likedCommentId) {
        return likeRestClient.likeComment(entityId, userId, likedCommentId);
    }

    public String unlikeComment(int entityId, int userId, int likedCommentId) {
        return likeRestClient.unlikeComment(entityId);
    }
}