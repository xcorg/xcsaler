package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohAttribute entity.
 */

@Entity
public class PohAttribute extends GenericModel {

    // Fields
    @Id
    public Short attrId;
    public Short catId;
    public String attrName;
    public Boolean attrInputType;
    public Boolean attrType;
    public String attrValues;
    public Boolean attrIndex;
    public Short sortOrder;
    public Boolean isLinked;
    public Boolean attrGroup;

}