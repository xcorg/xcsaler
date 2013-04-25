package models;

import javax.persistence.Entity;

import play.db.jpa.GenericModel;

/**
 * PohGoodsActivity entity.
 */

@Entity
public class PohGoodsActivity extends GenericModel {

    // Fields

    public Integer actId;
    public String actName;
    public String actDesc;
    public Short actType;
    public Integer goodsId;
    public Integer productId;
    public String goodsName;
    public Integer startTime;
    public Integer endTime;
    public Short isFinished;
    public String extInfo;

}