package models;

import java.util.Date;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class PohUnread extends Model {
    public String type;
    public Date date;
}
