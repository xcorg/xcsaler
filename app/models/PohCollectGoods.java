package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohCollectGoods entity.
 */

@Entity
public class PohCollectGoods extends GenericModel {

    // Fields
    @Id
    public Integer recId;
    public Long userId;
    public Integer goodsId;
    public Integer addTime;
    public Boolean isAttention;

}