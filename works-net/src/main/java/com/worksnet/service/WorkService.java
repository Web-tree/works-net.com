package com.worksnet.service;

import com.worksnet.dao.WorkDAO;
import com.worksnet.model.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author maxim.levicky
 *         Date: 2/20/13
 *         Time: 3:15 PM
 */
@Service
public class WorkService extends BaseService<Work> {
    protected WorkDAO dao;

    @Autowired
    public void setDao(WorkDAO dao) {
        this.dao = dao;
    }
}