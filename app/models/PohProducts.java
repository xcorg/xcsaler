package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohProducts entity.
 */

@Entity
public class PohProducts extends GenericModel {

    // Fields
    @Id
    public Integer productId;
    public Integer goodsId;
    public String goodsAttr;
    public String productSn;
    public Short productNumber;

}