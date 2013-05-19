package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohRegion entity.
 */

@Entity
public class PohRegion extends GenericModel {

    // Fields
    @Id
    public Long regionId;
    public Long parentId;
    public String regionName;
    public String regionType;
    public Long agencyId;

}