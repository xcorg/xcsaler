package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohGoodsCat entity.
 */

@Entity
public class PohGoodsCat extends GenericModel {

    // Fields
    @Id
    public Integer goodsId;
    public Short catId;

}