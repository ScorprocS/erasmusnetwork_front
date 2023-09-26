package fr.mns.jee.erasmusnetwork.like.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.mns.jee.erasmusnetwork.like.LikeRestClient;
import fr.mns.jee.erasmusnetwork.like.struct.LikedCommentStruct;
import fr.mns.jee.erasmusnetwork.like.struct.LikedPostStruct;
import fr.mns.jee.erasmusnetwork.like.struct.LikedUserStruct;
@Service
public class LikeRestClientService {
    @Autowired
    private LikeRestClient likeRestClient;

    public String likeUser(int entityId, int userId, int likedUserId) {
        LikedUserStruct likedUserStruct = new LikedUserStruct();
        return likeRestClient.likeUser(likedUserStruct);
    }

    public String unlikeUser(int entityId, int userId, int likedUserId) {
        return likeRestClient.unlikeUser(entityId);
    }

    public String likePost(int entityId, int userId, int likedPostId) {
        return likeRestClient.likePost(new LikedPostStruct());
    }

    public String unlikePost(int entityId, int userId, int likedPostId) {
        return likeRestClient.unlikePost(entityId);
    }

    public String likeComment(int entityId, int userId, int likedCommentId) {
        return likeRestClient.likeComment(new LikedCommentStruct());
    }

    public String unlikeComment(int entityId, int userId, int likedCommentId) {
        return likeRestClient.unlikeComment(entityId);
    }
}