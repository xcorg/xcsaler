package models;

import javax.persistence.Entity;

import play.db.jpa.GenericModel;

/**
 * PohMemberPrice entity.
 */

@Entity
public class PohMemberPrice extends GenericModel {

    // Fields
    public Integer priceId;
    public Integer goodsId;
    public Short userRank;
    public Double userPrice;

}