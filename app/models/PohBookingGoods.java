package models;

import javax.persistence.Entity;

import play.db.jpa.GenericModel;

/**
 * PohBookingGoods entity.
 */

@Entity
public class PohBookingGoods extends GenericModel {

    // Fields

    public Integer recId;
    public Integer userId;
    public String email;
    public String linkMan;
    public String tel;
    public Integer goodsId;
    public String goodsDesc;
    public Short goodsNumber;
    public Integer bookingTime;
    public Boolean isDispose;
    public String disposeUser;
    public Integer disposeTime;
    public String disposeNote;

}