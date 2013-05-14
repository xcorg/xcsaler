package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohSessionsData entity.
 */

@Entity
public class PohSessionsData extends GenericModel {

    // Fields
    @Id
    public String sesskey;
    public Integer expiry;
    public String data;

}