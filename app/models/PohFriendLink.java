package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohFriendLink entity.
 */

@Entity
public class PohFriendLink extends GenericModel {

    // Fields
    @Id
    public Short linkId;
    public String linkName;
    public String linkUrl;
    public String linkLogo;
    public Short showOrder;

}