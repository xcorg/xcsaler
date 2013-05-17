package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohTag entity.
 */

@Entity
public class PohTag extends GenericModel {

    // Fields
    @Id
    public Integer tagId;
    public Long userId;
    public Integer goodsId;
    public String tagWords;

}