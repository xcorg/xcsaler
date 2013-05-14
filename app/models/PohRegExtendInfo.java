package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohRegExtendInfo entity.
 */

@Entity
public class PohRegExtendInfo extends GenericModel {

    // Fields
    @Id
    public Integer id;
    public Integer userId;
    public Integer regFieldId;
    public String content;

}