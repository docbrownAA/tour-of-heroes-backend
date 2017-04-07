package com.mycompany.controller;

import com.mycompany.Service.HeroService;
import com.mycompany.domain.Hero;
import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gduvinage
 */
@RestController
@RequestMapping("/heroes")
public class HeroController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HeroController.class);

    @Autowired
    HeroService heroService;

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.OPTIONS})
    public Collection<Hero> readAll() {
        LOGGER.debug("Search all hero");
        return heroService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{idHero}")
    public Hero readOne(@PathVariable("idHero") int id) {
        LOGGER.debug("get hero with id:" + id);
        return heroService.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/", params = {"name"})
    public Collection<Hero> searchSome(@RequestParam("name") String term) {
        LOGGER.debug("Search hero with name containing:" + term);
        return heroService.findByNameContainig(term);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@RequestBody Hero hero) {
        LOGGER.debug("Create hero:" + hero.toString());
        return new ResponseEntity(heroService.create(hero), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{idHero}")
    public ResponseEntity<Hero> delete(@PathVariable("idHero") Integer idHero) {
        LOGGER.debug("Delte hero with id:" + idHero);
        heroService.delete(idHero);
        return new ResponseEntity<Hero>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "/{idHero}")
    public ResponseEntity<Hero> update(@RequestBody Hero hero, @PathVariable("idHero") Integer id) {
        Hero currentHero = heroService.findById(id);
        LOGGER.debug("Update hero:" + currentHero.toString() + " to " + hero.toString());
        currentHero.setName(hero.getName());
        heroService.upDate(currentHero);
        return new ResponseEntity<Hero>(currentHero, HttpStatus.OK);
    }
}
