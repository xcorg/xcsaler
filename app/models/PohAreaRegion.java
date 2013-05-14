package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohAreaRegion entity.
 */
@Entity
public class PohAreaRegion extends GenericModel {

    // Fields
    @Id
    public Short shippingAreaId;
    public Short regionId;

}