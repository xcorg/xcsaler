package models;

import javax.persistence.Entity;

import play.db.jpa.GenericModel;

/**
 * PohBackGoods entity.
 */

@Entity
public class PohBackGoods extends GenericModel {

    // Fields

    public Integer recId;
    public Integer backId;
    public Integer goodsId;
    public Integer productId;
    public String productSn;
    public String goodsName;
    public String brandName;
    public String goodsSn;
    public Boolean isReal;
    public Short sendNumber;
    public String goodsAttr;

}