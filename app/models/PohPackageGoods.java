package models;

import javax.persistence.Entity;

import play.db.jpa.GenericModel;

/**
 * PohPackageGoods entity.
 */

@Entity
public class PohPackageGoods extends GenericModel {

    // Fields

    public Integer packageId;
    public Integer goodsId;
    public Short adminId;
    public Integer productId;
    public Short goodsNumber;

}