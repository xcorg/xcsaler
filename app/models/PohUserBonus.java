package models;

import javax.persistence.Entity;

import play.db.jpa.GenericModel;

/**
 * PohUserBonus entity.
 */

@Entity
public class PohUserBonus extends GenericModel {

    // Fields

    public Integer bonusId;
    public Short bonusTypeId;
    public Long bonusSn;
    public Integer userId;
    public Integer usedTime;
    public Integer orderId;
    public Short emailed;

}