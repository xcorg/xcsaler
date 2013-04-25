package models;

import javax.persistence.Entity;

import play.db.jpa.GenericModel;

/**
 * PohDeliveryOrder entity.
 */

@Entity
public class PohDeliveryOrder extends GenericModel {

    // Fields

    public Integer deliveryId;
    public String deliverySn;
    public String orderSn;
    public Integer orderId;
    public String invoiceNo;
    public Integer addTime;
    public Short shippingId;
    public String shippingName;
    public Integer userId;
    public String actionUser;
    public String consignee;
    public String address;
    public Short country;
    public Short province;
    public Short city;
    public Short district;
    public String signBuilding;
    public String email;
    public String zipcode;
    public String tel;
    public String mobile;
    public String bestTime;
    public String postscript;
    public String howOos;
    public Double insureFee;
    public Double shippingFee;
    public Integer updateTime;
    public Short suppliersId;
    public Boolean status;
    public Short agencyId;

}