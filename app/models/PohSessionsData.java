package models;

import javax.persistence.Entity;

import play.db.jpa.GenericModel;

/**
 * PohSessionsData entity.
 */

@Entity
public class PohSessionsData extends GenericModel {

    // Fields

    public String sesskey;
    public Integer expiry;
    public String data;

}