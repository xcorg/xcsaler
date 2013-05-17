package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohAdminLog entity.
 */
@Entity
public class PohAdminLog extends GenericModel {

    // Fields
    @Id
    public Integer logId;
    public Integer logTime;
    public Long userId;
    public String logInfo;
    public String ipAddress;

}