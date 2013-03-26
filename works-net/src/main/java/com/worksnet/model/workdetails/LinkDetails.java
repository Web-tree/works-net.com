package com.worksnet.model.workdetails;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author maxim.levicky
 *         Date: 3/12/13
 *         Time: 11:18 AM
 */
@Entity
@DiscriminatorValue(value = "1")
public class LinkDetails extends WorkDetail {
    @Column(name = "link")
    protected String link;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
