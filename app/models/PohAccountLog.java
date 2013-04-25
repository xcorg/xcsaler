package models;

import javax.persistence.Entity;

import play.db.jpa.GenericModel;

/**
 * PohAccountLog entity.
 */
@Entity
public class PohAccountLog extends GenericModel {

    // Fields
    public Integer logId;
    public Integer userId;
    public Double userMoney;
    public Double frozenMoney;
    public Integer rankPoints;
    public Integer payPoints;
    public Integer changeTime;
    public String changeDesc;
    public Short changeType;

}