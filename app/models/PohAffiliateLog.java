package models;

import javax.persistence.Entity;

import play.db.jpa.GenericModel;

/**
 * * PohAffiliateLog entity.
 */

@Entity
public class PohAffiliateLog extends GenericModel {

    // Fields

    public Integer logId;
    public Integer orderId;
    public Integer time;
    public Integer userId;
    public String userName;
    public Double money;
    public Integer point;
    public Boolean separateType;

}