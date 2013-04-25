package models;

import javax.persistence.Entity;

import play.db.jpa.GenericModel;

/**
 * PohVolumePrice entity.
 */

@Entity
public class PohVolumePrice extends GenericModel {

    // Fields

    public Boolean priceType;
    public Integer goodsId;
    public Short volumeNumber;
    public Double volumePrice;

}