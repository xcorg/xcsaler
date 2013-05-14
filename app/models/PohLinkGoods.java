package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohLinkGoods entity.
 */

@Entity
public class PohLinkGoods extends GenericModel {

    // Fields
    @Id
    public Integer goodsId;
    public Integer linkGoodsId;
    public Short adminId;
    public Boolean isDouble;

}