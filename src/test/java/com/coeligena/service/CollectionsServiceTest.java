package com.coeligena.service;

import com.coeligena.model.CollectionsDO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * collections service test
 * Created by Ellery on 2018/9/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/configs/application-context.xml"})
@Transactional
@Rollback
public class CollectionsServiceTest {

    private CollectionsService collectionsService;

    @Test
    public void testSaveCollections() {
        CollectionsDO collectionsDO = new CollectionsDO();
        collectionsService.saveCollections(collectionsDO);

        Assert.assertEquals(collectionsDO.getId(), 1);
    }

    @Test
    public void testQueryCollectionByAnswerIdAndFolderId() {
        CollectionsDO collectionsDO = new CollectionsDO();
        collectionsService.saveCollections(collectionsDO);

        Assert.assertEquals(collectionsService.queryCollectionByAnswerIdAndFolderId(0, 0).getOwnerId(), 0);
    }

    @Autowired
    public void setCollectionsService(CollectionsService collectionsService) {
        this.collectionsService = collectionsService;
    }
}
