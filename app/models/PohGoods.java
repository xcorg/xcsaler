package models;

import javax.persistence.Entity;

import play.db.jpa.GenericModel;

/**
 * PohGoods entity.
 */

@Entity
public class PohGoods extends GenericModel {

    // Fields

    public Integer goodsId;
    public Short catId;
    public String goodsSn;
    public String goodsName;
    public String goodsNameStyle;
    public Integer clickCount;
    public Short brandId;
    public String providerName;
    public Short goodsNumber;
    public Double goodsWeight;
    public Double marketPrice;
    public Double shopPrice;
    public Double promotePrice;
    public Integer promoteStartDate;
    public Integer promoteEndDate;
    public Short warnNumber;
    public String keywords;
    public String goodsBrief;
    public String goodsDesc;
    public String goodsThumb;
    public String goodsImg;
    public String originalImg;
    public Short isReal;
    public String extensionCode;
    public Boolean isOnSale;
    public Boolean isAloneSale;
    public Boolean isShipping;
    public Integer integral;
    public Integer addTime;
    public Short sortOrder;
    public Boolean isDelete;
    public Boolean isBest;
    public Boolean isNew;
    public Boolean isHot;
    public Boolean isPromote;
    public Short bonusTypeId;
    public Integer lastUpdate;
    public Short goodsType;
    public String sellerNote;
    public Integer giveIntegral;
    public Integer rankIntegral;
    public Short suppliersId;
    public Boolean isCheck;

}