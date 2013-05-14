package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohBonusType entity.
 */

@Entity
public class PohBonusType extends GenericModel {

    // Fields
    @Id
    public Short typeId;
    public String typeName;
    public Double typeMoney;
    public Short sendType;
    public Double minAmount;
    public Double maxAmount;
    public Integer sendStartDate;
    public Integer sendEndDate;
    public Integer useStartDate;
    public Integer useEndDate;
    public Double minGoodsAmount;

}