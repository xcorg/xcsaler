package models;

import javax.persistence.Entity;

import play.db.jpa.GenericModel;

/**
 * PohPlugins entity.
 */

@Entity
public class PohPlugins extends GenericModel {

    // Fields

    public String code;
    public String version;
    public String library;
    public Boolean assign;
    public Integer installDate;

}