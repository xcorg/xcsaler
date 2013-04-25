package models;

import javax.persistence.Entity;

import play.db.jpa.GenericModel;

/**
 * PohDeliveryGoods entity.
 */

@Entity
public class PohDeliveryGoods extends GenericModel {

    // Fields

    public Integer recId;
    public Integer deliveryId;
    public Integer goodsId;
    public Integer productId;
    public String productSn;
    public String goodsName;
    public String brandName;
    public String goodsSn;
    public Boolean isReal;
    public String extensionCode;
    public Integer parentId;
    public Short sendNumber;
    public String goodsAttr;

}