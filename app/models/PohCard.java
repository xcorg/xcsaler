package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohCard entity.
 */

@Entity
public class PohCard extends GenericModel {

    // Fields
    @Id
    public Short cardId;
    public String cardName;
    public String cardImg;
    public Double cardFee;
    public Double freeMoney;
    public String cardDesc;

}