package models;

import javax.persistence.Entity;

import play.db.jpa.GenericModel;

/**
 * PohPack entity.
 */

@Entity
public class PohPack extends GenericModel {

    // Fields

    public Short packId;
    public String packName;
    public String packImg;
    public Double packFee;
    public Short freeMoney;
    public String packDesc;

}