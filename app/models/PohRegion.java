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
    public Short regionId;
    public Short parentId;
    public String regionName;
    public Boolean regionType;
    public Short agencyId;

}