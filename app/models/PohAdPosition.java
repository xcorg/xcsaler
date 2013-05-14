package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohAdPosition entity.
 */

@Entity
public class PohAdPosition extends GenericModel {

    // Fields
    @Id
    public Short positionId;
    public String positionName;
    public Short adWidth;
    public Short adHeight;
    public String positionDesc;
    public String positionStyle;

}