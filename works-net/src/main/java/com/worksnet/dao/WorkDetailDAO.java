package com.worksnet.dao;

import com.worksnet.model.workdetails.WorkDetail;

/**
 * @author maxim.levicky
 *         Date: 3/28/13
 *         Time: 2:35 PM
 */
public class WorkDetailDAO extends BaseDAO<WorkDetail> {
    @Override
    protected Class<WorkDetail> getClassType() {
        return WorkDetail.class;
    }

    @Override
    protected String getAllQuery() {
        return "from WorkDetails";
    }
}
