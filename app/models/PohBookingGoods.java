package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohBookingGoods entity.
 */

@Entity
public class PohBookingGoods extends GenericModel {

    // Fields
    @Id
    public Integer recId;
    public Long userId;
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