package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohCrons entity.
 */

@Entity
public class PohCrons extends GenericModel {

    // Fields
    @Id
    public Short cronId;
    public String cronCode;
    public String cronName;
    public String cronDesc;
    public Short cronOrder;
    public String cronConfig;
    public Integer thistime;
    public Integer nextime;
    public Short day;
    public String week;
    public String hour;
    public String minute;
    public Boolean enable;
    public Boolean runOnce;
    public String allowIp;
    public String alowFiles;

}