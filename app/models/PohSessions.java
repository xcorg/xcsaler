package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohSessions entity.
 */

@Entity
public class PohSessions extends GenericModel {

    // Fields
    @Id
    public String sesskey;
    public Integer expiry;
    public Long userId;
    public Integer adminid;
    public String ip;
    public String userName;
    public Short userRank;
    public Double discount;
    public String email;
    public String data;

}