package models;

import javax.persistence.Entity;

import play.db.jpa.GenericModel;

/**
 * PohUserFeed entity.
 */

@Entity
public class PohUserFeed extends GenericModel {

    // Fields

    public Integer feedId;
    public Integer userId;
    public Integer valueId;
    public Integer goodsId;
    public Boolean feedType;
    public Boolean isFeed;

}