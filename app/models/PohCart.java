package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohCart entity.
 */

@Entity
public class PohCart extends GenericModel {

    // Fields
    @Id
    public Integer recId;
    public Long userId;
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