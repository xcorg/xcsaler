package models;

import javax.persistence.Entity;

import play.db.jpa.GenericModel;

/**
 * PohGoodsAttr entity.
 */

@Entity
public class PohGoodsAttr extends GenericModel {

    // Fields

    public Integer goodsAttrId;
    public Integer goodsId;
    public Short attrId;
    public String attrValue;
    public String attrPrice;

}