package com.worksnet.model.worktypes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author maxim.levicky
 *         Date: 3/12/13
 *         Time: 11:00 AM
 */
@Entity
public class DefaultWork {
    @Id
    @Column(name = "id")
    private int id;


}
