package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohGroupGoods entity.
 */

@Entity
public class PohGroupGoods extends GenericModel {

    // Fields
    @Id
    public Integer parentId;
    public Integer goodsId;
    public Short adminId;
    public Double goodsPrice;

}