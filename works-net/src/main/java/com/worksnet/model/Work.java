package com.worksnet.model;

import javax.persistence.*;

/**
 * @author maxim.levicky
 *         Date: 2/27/13
 *         Time: 3:04 PM
 */
@Entity
@Table(name = "work")
public class Work extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    int id;
    @Column(name = "type", nullable = false)
    int type;
    @Column(name = "name", nullable = false)
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
