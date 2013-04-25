package models;

import javax.persistence.Entity;

import play.db.jpa.GenericModel;

/**
 * PohVote entity.
 */

@Entity
public class PohVote extends GenericModel {

    // Fields

    public Short voteId;
    public String voteName;
    public Integer startTime;
    public Integer endTime;
    public Boolean canMulti;
    public Integer voteCount;

}