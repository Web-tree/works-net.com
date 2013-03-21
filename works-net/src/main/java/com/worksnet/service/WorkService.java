package com.worksnet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public WorkDAO getDao() {
        return (WorkDAO) dao;
    }

    @Transactional
    public List<Work> getListByOwner(int ownerId) {
        return getDao().getListByOwnerId(ownerId);
    }
}