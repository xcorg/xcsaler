package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohStats entity.
 */

@Entity
public class PohStats extends GenericModel {

    // Fields
    @Id
    public Integer accessTime;
    public String ipAddress;
    public Short visitTimes;
    public String browser;
    public String system;
    public String language;
    public String area;
    public String refererDomain;
    public String refererPath;
    public String accessUrl;

}