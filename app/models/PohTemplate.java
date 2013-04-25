package models;

import javax.persistence.Entity;

import play.db.jpa.GenericModel;

/**
 * PohTemplate entity.
 */

@Entity
public class PohTemplate extends GenericModel {

    // Fields

    public String filename;
    public String region;
    public String library;
    public Boolean sortOrder;
    public Short id;
    public Boolean number;
    public Boolean type;
    public String theme;
    public String remarks;

}