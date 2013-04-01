package com.worksnet.model.workdetails;

import com.worksnet.model.Model;

import javax.persistence.*;

/**
 * @author maxim.levicky
 *         Date: 3/12/13
 *         Time: 11:00 AM
 */
@Entity
@DiscriminatorColumn(name = "type")
@Table(name = "work_details")
public class WorkDetail implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    protected int id;

    @Column(name = "work_id", nullable = false)
    protected int workId;

    @Column(name = "type", nullable = false, insertable = false, updatable = false)
    protected String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWorkId() {
        return workId;
    }

    public void setWorkId(int workId) {
        this.workId = workId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
