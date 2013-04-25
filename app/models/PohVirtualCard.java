package models;

import javax.persistence.Entity;

import play.db.jpa.GenericModel;

/**
 * PohVirtualCard entity.
 */

@Entity
public class PohVirtualCard extends GenericModel {

    // Fields

    public Integer cardId;
    public Integer goodsId;
    public String cardSn;
    public String cardPassword;
    public Integer addDate;
    public Integer endDate;
    public Boolean isSaled;
    public String orderSn;
    public String crc32;

}