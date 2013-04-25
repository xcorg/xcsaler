package models;

import javax.persistence.Entity;

import play.db.jpa.GenericModel;

/**
 * PohFriendLink entity.
 */

@Entity
public class PohFriendLink extends GenericModel {

    // Fields

    public Short linkId;
    public String linkName;
    public String linkUrl;
    public String linkLogo;
    public Short showOrder;

}