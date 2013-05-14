package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohOrderAction entity.
 */

@Entity
public class PohOrderAction extends GenericModel {

    // Fields
    @Id
    public Integer actionId;
    public Integer orderId;
    public String actionUser;
    public Boolean orderStatus;
    public Boolean shippingStatus;
    public Boolean payStatus;
    public Boolean actionPlace;
    public String actionNote;
    public Integer logTime;

}