package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohWholesale entity.
 */

@Entity
public class PohWholesale extends GenericModel {

    // Fields
    @Id
    public Integer actId;
    public Integer goodsId;
    public String goodsName;
    public String rankIds;
    public String prices;
    public Short enabled;

}