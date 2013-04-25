package models;

import javax.persistence.Entity;

import play.db.jpa.GenericModel;

/**
 * PohAdminLog entity.
 */
@Entity
public class PohAdminLog extends GenericModel {

    // Fields
    public Integer logId;
    public Integer logTime;
    public Short userId;
    public String logInfo;
    public String ipAddress;

}