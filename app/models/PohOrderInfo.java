package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohOrderInfo entity.
 */

@Entity
public class PohOrderInfo extends GenericModel {

    // Fields
    @Id
    public Integer orderId;
    public String orderSn;
    public Integer userId;
    public Boolean orderStatus;
    public Boolean shippingStatus;
    public Boolean payStatus;
    public String consignee;
    public Short country;
    public Short province;
    public Short city;
    public Short district;
    public String address;
    public String zipcode;
    public String tel;
    public String mobile;
    public String email;
    public String bestTime;
    public String signBuilding;
    public String postscript;
    public Short shippingId;
    public String shippingName;
    public Short payId;
    public String payName;
    public String howOos;
    public String howSurplus;
    public String packName;
    public String cardName;
    public String cardMessage;
    public String invPayee;
    public String invContent;
    public Double goodsAmount;
    public Double shippingFee;
    public Double insureFee;
    public Double payFee;
    public Double packFee;
    public Double cardFee;
    public Double moneyPaid;
    public Double surplus;
    public Integer integral;
    public Double integralMoney;
    public Double bonus;
    public Double orderAmount;
    public Short fromAd;
    public String referer;
    public Integer addTime;
    public Integer confirmTime;
    public Integer payTime;
    public Integer shippingTime;
    public Short packId;
    public Short cardId;
    public Integer bonusId;
    public String invoiceNo;
    public String extensionCode;
    public Integer extensionId;
    public String toBuyer;
    public String payNote;
    public Short agencyId;
    public String invType;
    public Double tax;
    public Boolean isSeparate;
    public Integer parentId;
    public Double discount;

}