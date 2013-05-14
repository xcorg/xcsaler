package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohGoodsType entity.
 */

@Entity
public class PohGoodsType extends GenericModel {

    // Fields
    @Id
    public Short catId;
    public String catName;
    public Boolean enabled;
    public String attrGroup;

}