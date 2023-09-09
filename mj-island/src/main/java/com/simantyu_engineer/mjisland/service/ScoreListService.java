package com.simantyu_engineer.mjisland.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import com.simantyu_engineer.mjisland.domain.model.groupList;
import com.simantyu_engineer.mjisland.domain.model.vScoreList;
import com.simantyu_engineer.mjisland.repository.GroupListRepository;
// import com.simantyu_engineer.mjisland.domain.model.vScoreListSpecifications;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Service
@Transactional
public class ScoreListService {
    @Autowired
    private GroupListRepository glRepo;

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * グループ一覧 - レコードを全件取得
     */
    public List<groupList> findAllGroupList() {
        return glRepo.findAll();
    }

    public List<vScoreList> findScoreList(Date eventDateFrom, Date eventDateTo, String groupId) {
        String sql = "SELECT sl FROM vScoreList sl ";
        sql += "WHERE (:groupId IS NULL OR sl.group_id = :groupId) ";
        if (eventDateFrom != null) {
            sql += "AND sl.event_date >= :eventDateFrom ";
        }
        if (eventDateTo != null) {
            sql += "AND sl.event_date <= :eventDateTo ";
        }
        TypedQuery<vScoreList> query = entityManager.createQuery(sql, vScoreList.class);

        query.setParameter("groupId", groupId);
        if (eventDateFrom != null) {
            query.setParameter("eventDateFrom", eventDateFrom);
        }
        if (eventDateTo != null) {
            query.setParameter("eventDateTo", eventDateTo);
        }

        return query.getResultList();

        // Specification<vScoreList> spec = vScoreListSpecifications.filter(eventDateFrom, eventDateTo, groupId);
        // return slRepo.findAll(spec);
    }
}
