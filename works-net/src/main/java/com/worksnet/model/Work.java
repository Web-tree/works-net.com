package com.worksnet.model;

import javax.persistence.*;

/**
 * @author maxim.levicky
 *         Date: 2/27/13
 *         Time: 3:04 PM
 */
@Entity
@Table(name = "work")
public class Work {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    int id;
    @Column(name = "type", nullable = false)
    int type;
    @Column(name = "name", nullable = false)
    String name;


}
