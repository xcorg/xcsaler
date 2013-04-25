package models;

import javax.persistence.Entity;

import play.db.jpa.GenericModel;

/**
 * PohAdminMessage entity.
 */

@Entity
public class PohAdminMessage extends GenericModel {

    // Fields

    public Short messageId;
    public Short senderId;
    public Short receiverId;
    public Integer sentTime;
    public Integer readTime;
    public Boolean readed;
    public Boolean deleted;
    public String title;
    public String message;

}