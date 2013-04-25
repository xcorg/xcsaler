package models;

import javax.persistence.Entity;

import play.db.jpa.GenericModel;

/**
 * PohShipping entity.
 */

@Entity
public class PohShipping extends GenericModel {

    // Fields

    public Short shippingId;
    public String shippingCode;
    public String shippingName;
    public String shippingDesc;
    public String insure;
    public Boolean supportCod;
    public Boolean enabled;
    public String shippingPrint;
    public String printBg;
    public String configLable;
    public Boolean printModel;
    public Short shippingOrder;

}