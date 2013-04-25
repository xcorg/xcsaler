package models;

import javax.persistence.Entity;

import play.db.jpa.GenericModel;

/**
 * PohAd entity.
 */
@Entity
public class PohAd extends GenericModel {

    // Fields
    public Short adId;
    public Short positionId;
    public Short mediaType;
    public String adName;
    public String adLink;
    public String adCode;
    public Integer startTime;
    public Integer endTime;
    public String linkMan;
    public String linkEmail;
    public String linkPhone;
    public Integer clickCount;
    public Short enabled;

}