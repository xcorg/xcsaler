package models;

import javax.persistence.Entity;

import play.db.jpa.GenericModel;

/**
 * PohTag entity.
 */

@Entity
public class PohTag extends GenericModel {

    // Fields

    public Integer tagId;
    public Integer userId;
    public Integer goodsId;
    public String tagWords;

}