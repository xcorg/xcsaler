package models;

import javax.persistence.Entity;

import play.db.jpa.GenericModel;

/**
 * PohWholesale entity.
 */

@Entity
public class PohWholesale extends GenericModel {

    // Fields

    public Integer actId;
    public Integer goodsId;
    public String goodsName;
    public String rankIds;
    public String prices;
    public Short enabled;

}