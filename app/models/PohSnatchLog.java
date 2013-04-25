package models;

import javax.persistence.Entity;

import play.db.jpa.GenericModel;

/**
 * PohSnatchLog entity.
 */

@Entity
public class PohSnatchLog extends GenericModel {

    // Fields

    public Integer logId;
    public Short snatchId;
    public Integer userId;
    public Double bidPrice;
    public Integer bidTime;

}