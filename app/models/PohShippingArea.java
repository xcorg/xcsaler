package models;

import javax.persistence.Entity;

import play.db.jpa.GenericModel;

/**
 * PohShippingArea entity.
 */

@Entity
public class PohShippingArea extends GenericModel {

    // Fields

    public Short shippingAreaId;
    public String shippingAreaName;
    public Short shippingId;
    public String configure;

}