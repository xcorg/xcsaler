package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohPayLog entity.
 */

@Entity
public class PohPayLog extends GenericModel {

    // Fields
    @Id
    public Integer logId;
    public Integer orderId;
    public Double orderAmount;
    public Boolean orderType;
    public Boolean isPaid;

}