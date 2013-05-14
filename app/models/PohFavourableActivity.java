package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohFavourableActivity entity.
 */

@Entity
public class PohFavourableActivity extends GenericModel {

    // Fields
    @Id
    public Short actId;
    public String actName;
    public Integer startTime;
    public Integer endTime;
    public String userRank;
    public Short actRange;
    public String actRangeExt;
    public Double minAmount;
    public Double maxAmount;
    public Short actType;
    public Double actTypeExt;
    public String gift;
    public Short sortOrder;

}