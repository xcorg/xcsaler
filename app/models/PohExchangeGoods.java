package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohExchangeGoods entity.
 */

@Entity
public class PohExchangeGoods extends GenericModel {

    // Fields
    @Id
    public Integer goodsId;
    public Integer exchangeIntegral;
    public Boolean isExchange;
    public Boolean isHot;

}