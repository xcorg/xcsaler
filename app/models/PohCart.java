package models;

import javax.persistence.Entity;

import play.db.jpa.GenericModel;

/**
 * PohCart entity.
 */

@Entity
public class PohCart extends GenericModel {

    // Fields

    public Integer recId;
    public Integer userId;
    public String sessionId;
    public Integer goodsId;
    public String goodsSn;
    public Integer productId;
    public String goodsName;
    public Double marketPrice;
    public Double goodsPrice;
    public Short goodsNumber;
    public String goodsAttr;
    public Boolean isReal;
    public String extensionCode;
    public Integer parentId;
    public Boolean recType;
    public Short isGift;
    public Boolean isShipping;
    public Short canHandsel;
    public String goodsAttrId;

}