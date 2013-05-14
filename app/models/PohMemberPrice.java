package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohMemberPrice entity.
 */

@Entity
public class PohMemberPrice extends GenericModel {

    // Fields
    @Id
    public Integer priceId;
    public Integer goodsId;
    public Short userRank;
    public Double userPrice;

}