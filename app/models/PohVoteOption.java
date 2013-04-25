package models;

import javax.persistence.Entity;

import play.db.jpa.GenericModel;

/**
 * PohVoteOption entity.
 */

@Entity
public class PohVoteOption extends GenericModel {

    // Fields

    public Short optionId;
    public Short voteId;
    public String optionName;
    public Integer optionCount;
    public Short optionOrder;

}