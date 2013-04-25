package models;

import javax.persistence.Entity;

import play.db.jpa.GenericModel;

/**
 * PohAuctionLog entity.
 */

@Entity
public class PohAuctionLog extends GenericModel {

    // Fields

    public Integer logId;
    public Integer actId;
    public Integer bidUser;
    public Double bidPrice;
    public Integer bidTime;

}