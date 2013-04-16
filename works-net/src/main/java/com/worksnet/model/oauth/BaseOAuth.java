package com.worksnet.model.oauth;

import com.worksnet.model.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Max Levicky
 *         Date: 13.04.13
 *         Time: 23:27
 */
@Entity
@Table(name = "work_details")
public class BaseOAuth implements Model {
    @Id
    protected int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
