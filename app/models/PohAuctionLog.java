package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohAuctionLog entity.
 */

@Entity
public class PohAuctionLog extends GenericModel {

    // Fields
    @Id
    public Integer logId;
    public Integer actId;
    public Integer bidUser;
    public Double bidPrice;
    public Integer bidTime;

}