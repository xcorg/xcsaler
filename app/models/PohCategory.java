package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohCategory entity.
 */

@Entity
public class PohCategory extends GenericModel {

    // Fields
    @Id
    public Short catId;
    public String catName;
    public String keywords;
    public String catDesc;
    public Short parentId;
    public Boolean sortOrder;
    public String templateFile;
    public String measureUnit;
    public Boolean showInNav;
    public String style;
    public Boolean isShow;
    public Short grade;
    public String filterAttr;

}