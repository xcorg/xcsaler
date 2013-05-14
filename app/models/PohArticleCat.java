package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohArticleCat entity.
 */

@Entity
public class PohArticleCat extends GenericModel {

    // Fields
    @Id
    public Short catId;
    public String catName;
    public Boolean catType;
    public String keywords;
    public String catDesc;
    public Short sortOrder;
    public Boolean showInNav;
    public Short parentId;

}