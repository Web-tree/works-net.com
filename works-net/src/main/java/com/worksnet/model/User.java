package com.worksnet.model;

import java.util.Date;

import javax.persistence.*;


/**
 * @author maxim.levicky
 *         Date: 2/20/13
 *         Time: 2:44 PM
 */
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "birth", nullable = false)
    private Date birth;
}
