package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohAgency entity.
 */

@Entity
public class PohAgency extends GenericModel {

    // Fields
    @Id
    public Short agencyId;
    public String agencyName;
    public String agencyDesc;

}