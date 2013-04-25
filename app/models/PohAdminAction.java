package models;

import javax.persistence.Entity;

import play.db.jpa.GenericModel;

/**
 * PohAdminAction entity.
 */

@Entity
public class PohAdminAction extends GenericModel {

    // Fields
    public Short actionId;
    public Short parentId;
    public String actionCode;
    public String relevance;

}