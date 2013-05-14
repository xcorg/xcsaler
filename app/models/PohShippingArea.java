package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohShippingArea entity.
 */

@Entity
public class PohShippingArea extends GenericModel {

    // Fields
    @Id
    public Short shippingAreaId;
    public String shippingAreaName;
    public Short shippingId;
    public String configure;

}