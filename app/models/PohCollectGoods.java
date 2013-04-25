package models;

import javax.persistence.Entity;

import play.db.jpa.GenericModel;

/**
 * PohCollectGoods entity.
 */

@Entity
public class PohCollectGoods extends GenericModel {

    // Fields

    public Integer recId;
    public Integer userId;
    public Integer goodsId;
    public Integer addTime;
    public Boolean isAttention;

}