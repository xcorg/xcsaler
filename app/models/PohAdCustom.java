package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohAdCustom entity.
 */
@Entity
public class PohAdCustom extends GenericModel {

    // Fields
    @Id
    public Integer adId;
    public Boolean adType;
    public String adName;
    public Integer addTime;
    public String content;
    public String url;
    public Short adStatus;

}