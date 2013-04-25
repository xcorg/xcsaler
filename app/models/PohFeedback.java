package models;

import javax.persistence.Entity;

import play.db.jpa.GenericModel;

/**
 * PohFeedback entity.
 */

@Entity
public class PohFeedback extends GenericModel {

    // Fields

    public Integer msgId;
    public Integer parentId;
    public Integer userId;
    public String userName;
    public String userEmail;
    public String msgTitle;
    public Boolean msgType;
    public Boolean msgStatus;
    public String msgContent;
    public Integer msgTime;
    public String messageImg;
    public Integer orderId;
    public Boolean msgArea;

}