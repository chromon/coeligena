package com.coeligena.dao;

import com.coeligena.model.VotesDO;

/**
 * <p>
 *     回答投票信息数据访问对象
 * </p>
 * Created by Ellery on 2018/7/30.
 */
public interface VotesDAO {

    /**
     * 添加投票信息
     * @param votesDO 投票信息
     */
    void addVotes(VotesDO votesDO);

    /**
     * 由回答 id 和投票用户 id 查询投票信息
     * @param answerId 回答 id
     * @param voterId 投票用户 id
     * @return 投票信息
     */
    VotesDO queryVotesByAnswerIdAndVoterId(int answerId, int voterId);
}
