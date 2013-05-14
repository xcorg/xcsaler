package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohPackageGoods entity.
 */

@Entity
public class PohPackageGoods extends GenericModel {

    // Fields
    @Id
    public Integer packageId;
    public Integer goodsId;
    public Short adminId;
    public Integer productId;
    public Short goodsNumber;

}