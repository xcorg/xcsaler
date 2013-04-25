package models;

import javax.persistence.Entity;

import play.db.jpa.GenericModel;

/**
 * PohLinkGoods entity.
 */

@Entity
public class PohLinkGoods extends GenericModel {

    // Fields

    public Integer goodsId;
    public Integer linkGoodsId;
    public Short adminId;
    public Boolean isDouble;

}