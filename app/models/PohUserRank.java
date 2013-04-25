package models;

import javax.persistence.Entity;

import play.db.jpa.GenericModel;

/**
 * PohUserRank entity.
 */

@Entity
public class PohUserRank extends GenericModel {

    // Fields

    public Short rankId;
    public String rankName;
    public Integer minPoints;
    public Integer maxPoints;
    public Short discount;
    public Boolean showPrice;
    public Boolean specialRank;

}