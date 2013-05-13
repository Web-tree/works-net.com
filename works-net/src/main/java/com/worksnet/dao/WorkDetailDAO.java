package com.worksnet.dao;

import com.worksnet.model.workdetails.WorkDetail;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * @author maxim.levicky
 *         Date: 3/28/13
 *         Time: 2:35 PM
 */
public class WorkDetailDAO extends BaseDAO<WorkDetail> {

    @SuppressWarnings("unchecked")
    public List<WorkDetail> getDetailsByWorkId(int workId) {
        return (List<WorkDetail>) db.createCriteria(WorkDetail.class)
                .add(Restrictions.eq("workId", workId))
                .list();
    }

    @Override
    protected Class<WorkDetail> getModelType() {
        return WorkDetail.class;
    }

    @Override
    protected String getAllQuery() {
        return "from WorkDetails";
    }
}
