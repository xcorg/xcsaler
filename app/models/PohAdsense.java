package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohAdsense entity.
 */
@Entity
public class PohAdsense extends GenericModel {

    // Fields
    @Id
    public Short fromAd;
    public String referer;
    public Integer clicks;

}