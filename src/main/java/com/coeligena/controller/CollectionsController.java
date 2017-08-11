package com.coeligena.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * collections controller
 *
 * Created by Ellery on 2017/8/11.
 */

@Controller
public class CollectionsController {

    @RequestMapping(value = "/collections", method = RequestMethod.GET)
    public String collections() {
        return "collections";
    }

    @RequestMapping(value = "/collection/{collectionId}", method = RequestMethod.GET)
    public String collection(@PathVariable int collectionId, Model model) {
        return "collection";
    }

    @RequestMapping(value = "/collection/{collectionId}/log", method = RequestMethod.GET)
    public String collectionLog(@PathVariable int collectionId, Model model) {
        return "collectionLog";
    }
}
