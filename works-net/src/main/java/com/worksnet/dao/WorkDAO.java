package com.worksnet.dao;

import com.worksnet.model.Work;

/**
 * @author maxim.levicky
 *         Date: 3/1/13
 *         Time: 12:01 PM
 */
public class WorkDAO extends BaseDAO<Work> {

    @Override
    protected String getAllQuery() {
        return "from works";
    }

    @Override
    protected Class<Work> getClassType() {
        return Work.class;
    }
}
