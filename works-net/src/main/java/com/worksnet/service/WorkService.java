package com.worksnet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worksnet.dao.WorkDAO;
import com.worksnet.model.Work;

/**
 * @author maxim.levicky
 *         Date: 2/20/13
 *         Time: 3:15 PM
 */
@Service
public class WorkService extends BaseService<Work> {
    @Autowired
    public void setDao(WorkDAO dao) {
        this.dao = dao;
    }
}