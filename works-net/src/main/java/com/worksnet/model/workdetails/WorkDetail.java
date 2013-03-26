package com.worksnet.model.workdetails;

import javax.persistence.*;

/**
 * @author maxim.levicky
 *         Date: 3/12/13
 *         Time: 11:00 AM
 */
@Entity
@DiscriminatorColumn(name = "type")
public class WorkDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    protected int id;

    @Column(name = "work_id", nullable = false)
    protected int workId;

    @Column(name = "type", nullable = false, insertable = false, updatable = false)
    protected int type;

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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
