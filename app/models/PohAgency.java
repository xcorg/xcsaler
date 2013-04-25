package models;

import javax.persistence.Entity;

import play.db.jpa.GenericModel;

/**
 * PohAgency entity.
 */

@Entity
public class PohAgency extends GenericModel {

    // Fields

    public Short agencyId;
    public String agencyName;
    public String agencyDesc;

}