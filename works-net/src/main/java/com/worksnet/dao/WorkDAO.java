package com.worksnet.dao;

import com.worksnet.model.Work;

/**
 * @author maxim.levicky
 *         Date: 2/20/13
 *         Time: 3:01 PM
 */
public class WorkDAO extends BaseDAO<Work> {

    @Override
    protected Class<Work> getClassType() {
        return Work.class;
    }

    @Override
    protected String getAllQuery() {
        return "from Work";
    }
}
