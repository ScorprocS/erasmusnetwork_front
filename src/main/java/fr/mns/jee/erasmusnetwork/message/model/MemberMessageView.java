package fr.mns.jee.erasmusnetwork.message.model;

import java.io.Serializable;
import java.sql.Date;


public class MemberMessageView implements Serializable {
    private MemberMessageViewPK id = new MemberMessageViewPK();

    private Date viewedAt;

    private Member member;


    private Message message;

    public MemberMessageViewPK getId() {
        return id;
    }

    public void setId(MemberMessageViewPK id) {
        this.id = id;
    }

    public Date getViewedAt() {
        return viewedAt;
    }

    public void setViewedAt(Date viewedAt) {
        this.viewedAt = viewedAt;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
