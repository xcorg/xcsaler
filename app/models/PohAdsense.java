package models;

import javax.persistence.Entity;

import play.db.jpa.GenericModel;

/**
 * PohAdsense entity.
 */
@Entity
public class PohAdsense extends GenericModel {

    // Fields
    public Short fromAd;
    public String referer;
    public Integer clicks;

}