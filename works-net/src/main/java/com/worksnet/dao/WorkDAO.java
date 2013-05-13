package com.worksnet.dao;

import com.worksnet.model.Work;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * @author maxim.levicky
 *         Date: 2/20/13
 *         Time: 3:01 PM
 */
public class WorkDAO extends BaseDAO<Work> {

    @Override
    protected Class<Work> getModelType() {
        return Work.class;
    }

    @Override
    protected String getAllQuery() {
        return "from Work";
    }

    @SuppressWarnings("unchecked")
    public List<Work> getListByOwnerId(int ownerId) {
        return (List<Work>) db.createCriteria(Work.class)
                .add(Restrictions.eq("ownerId", ownerId))
                .list();
    }
}
