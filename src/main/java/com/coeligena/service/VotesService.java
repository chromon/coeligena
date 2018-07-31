package com.coeligena.service;

import com.coeligena.model.VotesDO;

/**
 * <p>
 *     投票信息业务逻辑实现接口
 * </p>
 * Created by Ellery on 2018/7/30.
 */
public interface VotesService {

    /**
     * 添加投票信息
     * @param votesDO 投票信息
     */
    void saveVotes(VotesDO votesDO);

    /**
     * 由回答 id 和投票用户 id 查询投票信息
     * @param answerId 回答 id
     * @param voterId 投票用户 id
     * @return 投票信息
     */
    VotesDO queryVotesByAnswerIdAndVoterId(int answerId, int voterId);

    /**
     * 更新投票信息
     * @param votesDO 投票信息
     */
    void modifyVotes(VotesDO votesDO);

    /**
     * 删除投票信息
     * @param votesDO 投票信息
     */
    void deleteVotes(VotesDO votesDO);
}
