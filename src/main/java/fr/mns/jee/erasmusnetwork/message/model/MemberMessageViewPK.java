package fr.mns.jee.erasmusnetwork.message.model;


import java.io.Serializable;

public class MemberMessageViewPK implements Serializable {

    private Long memberId;

    private Long messageId;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }
}
