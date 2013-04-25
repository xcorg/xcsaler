package models;

import javax.persistence.Entity;

import play.db.jpa.GenericModel;

/**
 * PohComment entity.
 */

@Entity
public class PohComment extends GenericModel {

    // Fields

    public Integer commentId;
    public Short commentType;
    public Integer idValue;
    public String email;
    public String userName;
    public String content;
    public Boolean commentRank;
    public Integer addTime;
    public String ipAddress;
    public Short status;
    public Integer parentId;
    public Integer userId;

}