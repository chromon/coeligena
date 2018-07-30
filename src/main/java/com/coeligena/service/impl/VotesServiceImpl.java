package com.coeligena.service.impl;

import com.coeligena.dao.VotesDAO;
import com.coeligena.model.VotesDO;
import com.coeligena.service.VotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *     投票信息业务逻辑实现
 * </p>
 * Created by Ellery on 2018/7/30.
 */
@Service("votesService")
public class VotesServiceImpl implements VotesService {

    private VotesDAO votesDAO;

    /**
     * 添加投票信息
     * @param votesDO 投票信息
     */
    @Override
    public void saveVotes(VotesDO votesDO) {
        this.votesDAO.addVotes(votesDO);
    }

    /**
     * 由回答 id 和投票用户 id 查询投票信息
     * @param answerId 回答 id
     * @param voterId 投票用户 id
     * @return 投票信息
     */
    @Override
    public VotesDO queryVotesByAnswerIdAndVoterId(int answerId, int voterId) {
        return this.votesDAO.queryVotesByAnswerIdAndVoterId(answerId, voterId);
    }

    @Autowired
    public void setVotesDAO(VotesDAO votesDAO) {
        this.votesDAO = votesDAO;
    }
}
