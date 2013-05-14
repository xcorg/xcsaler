package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * * PohAffiliateLog entity.
 */

@Entity
public class PohAffiliateLog extends GenericModel {

    // Fields
    @Id
    public Integer logId;
    public Integer orderId;
    public Integer time;
    public Integer userId;
    public String userName;
    public Double money;
    public Integer point;
    public Boolean separateType;

}