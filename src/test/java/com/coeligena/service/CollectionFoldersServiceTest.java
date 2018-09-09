package com.coeligena.service;

import com.coeligena.model.CollectionFoldersDO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * collection folders service test
 * Created by Ellery on 2018/9/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/configs/application-context.xml"})
@Transactional
@Rollback
public class CollectionFoldersServiceTest {

    private CollectionFoldersService collectionFoldersService;

    @Test
    public void testSaveCollectionFolders() {
        CollectionFoldersDO collectionFoldersDO = new CollectionFoldersDO();
        collectionFoldersDO.setFolderName("test");
        collectionFoldersDO.setDescription("collection folder");
        this.collectionFoldersService.saveCollectionFolders(collectionFoldersDO);

        Assert.assertEquals(collectionFoldersDO.getId(), 1);
    }

    @Autowired
    public void setCollectionFoldersService(CollectionFoldersService collectionFoldersService) {
        this.collectionFoldersService = collectionFoldersService;
    }
}
