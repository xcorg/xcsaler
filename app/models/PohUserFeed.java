package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohUserFeed entity.
 */

@Entity
public class PohUserFeed extends GenericModel {

    // Fields
    @Id
    public Integer feedId;
    public Long userId;
    public Integer valueId;
    public Integer goodsId;
    public Boolean feedType;
    public Boolean isFeed;

}