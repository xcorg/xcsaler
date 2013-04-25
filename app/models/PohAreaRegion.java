package models;

import javax.persistence.Entity;

import play.db.jpa.GenericModel;

/**
 * PohAreaRegion entity.
 */
@Entity
public class PohAreaRegion extends GenericModel {

    // Fields
    public Short shippingAreaId;
    public Short regionId;

}