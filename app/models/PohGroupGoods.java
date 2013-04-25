package models;

import javax.persistence.Entity;

import play.db.jpa.GenericModel;

/**
 * PohGroupGoods entity.
 */

@Entity
public class PohGroupGoods extends GenericModel {

    // Fields

    public Integer parentId;
    public Integer goodsId;
    public Short adminId;
    public Double goodsPrice;

}