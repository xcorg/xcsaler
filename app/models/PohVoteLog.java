package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohVoteLog entity.
 */

@Entity
public class PohVoteLog extends GenericModel {

    // Fields
    @Id
    public Integer logId;
    public Short voteId;
    public String ipAddress;
    public Integer voteTime;

}