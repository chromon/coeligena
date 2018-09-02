package com.coeligena.service;

import com.coeligena.function.date.DateUtils;
import com.coeligena.model.VotesDO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * votes service test
 * Created by Ellery on 2018/9/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/configs/application-context.xml"})
@Transactional
@Rollback
public class VotesServiceTest {

    private VotesService votesService;

    @Test
    public void testSaveVotes() {
        VotesDO votesDO = new VotesDO();
        votesDO.setVoteTime(DateUtils.currentTime());
        votesService.saveVotes(votesDO);

        Assert.assertEquals(votesDO.getVoterId(), 0);
    }

    @Test
    public void testQueryVotesByAnswerIdAndVoterId() {
        VotesDO votesDO = new VotesDO();
        votesDO.setVoteTime(DateUtils.currentTime());
        votesService.saveVotes(votesDO);

        Assert.assertEquals(votesService.queryVotesByAnswerIdAndVoterId(
                votesDO.getAnswerId(), votesDO.getVoterId()).getVoteType(), 0);
    }

    @Test
    public void testModifyVotes() {
        VotesDO votesDO = new VotesDO();
        votesDO.setVoteTime(DateUtils.currentTime());
        votesService.saveVotes(votesDO);

        votesDO.setVoterId(1);
        votesService.modifyVotes(votesDO);

        Assert.assertEquals(votesService.queryVotesByAnswerIdAndVoterId(
                votesDO.getAnswerId(), votesDO.getVoterId()).getVoterId(), votesDO.getVoterId());
    }

    @Autowired
    public void setVotesService(VotesService votesService) {
        this.votesService = votesService;
    }
}
