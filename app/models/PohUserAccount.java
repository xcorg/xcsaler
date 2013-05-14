package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohUserAccount entity.
 */

@Entity
public class PohUserAccount extends GenericModel {

    // Fields
    @Id
    public Integer id;
    public Integer userId;
    public String adminUser;
    public Double amount;
    public Integer addTime;
    public Integer paidTime;
    public String adminNote;
    public String userNote;
    public Boolean processType;
    public String payment;
    public Boolean isPaid;

}