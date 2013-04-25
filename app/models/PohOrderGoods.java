package models;

import javax.persistence.Entity;

import play.db.jpa.GenericModel;

/**
 * PohOrderGoods entity.
 */

@Entity
public class PohOrderGoods extends GenericModel {

    // Fields

    public Integer recId;
    public Integer orderId;
    public Integer goodsId;
    public String goodsName;
    public String goodsSn;
    public Integer productId;
    public Short goodsNumber;
    public Double marketPrice;
    public Double goodsPrice;
    public String goodsAttr;
    public Short sendNumber;
    public Boolean isReal;
    public String extensionCode;
    public Integer parentId;
    public Short isGift;
    public String goodsAttrId;

}