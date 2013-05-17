package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohSnatchLog entity.
 */

@Entity
public class PohSnatchLog extends GenericModel {

    // Fields
    @Id
    public Integer logId;
    public Short snatchId;
    public Long userId;
    public Double bidPrice;
    public Integer bidTime;

}