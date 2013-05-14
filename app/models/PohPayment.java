package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohPayment entity.
 */

@Entity
public class PohPayment extends GenericModel {

    // Fields
    @Id
    public Short payId;
    public String payCode;
    public String payName;
    public String payFee;
    public String payDesc;
    public Short payOrder;
    public String payConfig;
    public Boolean enabled;
    public Boolean isCod;
    public Boolean isOnline;

}