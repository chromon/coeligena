package com.coeligena.dao.impl;

import com.coeligena.dao.VotesDAO;
import com.coeligena.model.VotesDO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * <p>
 *     投票信息持久化
 * </p>
 * Created by Ellery on 2018/7/30.
 */
@Repository
public class VotesDAOImpl implements VotesDAO {

    @Resource
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * 添加投票信息
     * @param votesDO 投票信息
     */
    @Override
    public void addVotes(VotesDO votesDO) {
        this.getSession().save(votesDO);
    }

    /**
     * 由回答 id 和投票用户 id 查询投票信息
     * @param answerId 回答 id
     * @param voterId 投票用户 id
     * @return 投票信息
     */
    @Override
    public VotesDO queryVotesByAnswerIdAndVoterId(int answerId, int voterId) {
        String sql = "select v from VotesDO v where v.answerId =:answerId and v.voterId =:voterId";
        Query query = this.getSession().createQuery(sql);
        query.setParameter("answerId", answerId);
        query.setParameter("voterId", voterId);
        return (VotesDO) query.uniqueResult();
    }

    /**
     * 更新投票信息
     * @param votesDO 投票信息
     */
    @Override
    public void updateVotes(VotesDO votesDO) {
        this.getSession().update(votesDO);
    }

    /**
     * 删除投票信息
     * @param votesDO 投票信息
     */
    @Override
    public void deleteVotes(VotesDO votesDO) {
        this.getSession().delete(votesDO);
    }
}
