package com.worksnet.service;

import com.worksnet.dao.WorkDAO;
import com.worksnet.dao.WorkDetailDAO;
import com.worksnet.model.Work;
import com.worksnet.model.oauth.GitHubAuth;
import com.worksnet.model.workdetails.GitHubDetails;
import com.worksnet.model.workdetails.WorkDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author maxim.levicky
 *         Date: 2/20/13
 *         Time: 3:15 PM
 */
@Service
public class WorkService extends BaseService<Work> {
    @Autowired
    WorkDetailDAO detailsDAO;

    @Autowired
    public void setDao(WorkDAO dao) {
        this.dao = dao;
    }

    public WorkDAO getDao() {
        return (WorkDAO) dao;
    }

    public List<Work> getListByOwner(int ownerId) {
        return getDao().getListByOwnerId(ownerId);
    }

    public int saveDetails(WorkDetail detail) {
        return detailsDAO.save(detail);
    }

    public List<WorkDetail> getDetails(int workId) {
        return detailsDAO.getDetailsByWorkId(workId);
    }

    public void checkDetails(GitHubDetails gitHubDetails) {
        for (GitHubAuth gitHubAuth : UserService.getCurrentUser().getGitHubAuths()) {
            if (gitHubAuth.getLogin().equals(gitHubDetails.getLogin())) {
                gitHubDetails.setChecked(true);
                detailsDAO.save(gitHubDetails);
            }
        }
    }

    public static class WrongDetailType extends Error {
    }
}