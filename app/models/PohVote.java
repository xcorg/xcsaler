package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohVote entity.
 */

@Entity
public class PohVote extends GenericModel {

    // Fields
    @Id
    public Short voteId;
    public String voteName;
    public Integer startTime;
    public Integer endTime;
    public Boolean canMulti;
    public Integer voteCount;

}