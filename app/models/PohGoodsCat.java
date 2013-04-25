package models;

import javax.persistence.Entity;

import play.db.jpa.GenericModel;

/**
 * PohGoodsCat entity.
 */

@Entity
public class PohGoodsCat extends GenericModel {

    // Fields

    public Integer goodsId;
    public Short catId;

}