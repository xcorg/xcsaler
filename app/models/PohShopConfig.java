package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohShopConfig entity.
 */

@Entity
public class PohShopConfig extends GenericModel {

    // Fields
    @Id
    public Short id;
    public Short parentId;
    public String code;
    public String type;
    public String storeRange;
    public String storeDir;
    public String value;
    public Short sortOrder;

}