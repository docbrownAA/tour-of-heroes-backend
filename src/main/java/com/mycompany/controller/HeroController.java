package com.mycompany.controller;

import com.mycompany.Service.HeroService;
import com.mycompany.domain.Hero;
import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@CrossOrigin(origins = "http://localhost:4200",methods = RequestMethod.GET)
public class HeroController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(HeroController.class);
    
    @Autowired
    HeroService heroService;
    @RequestMapping(method = RequestMethod.GET)
    public Collection<Hero> readAll(){
        return heroService.findAll();
    }
    
//    @RequestMapping(method = RequestMethod.GET, value="/{idHero}")
//    @CrossOrigin(origins = "http://localhost:4200")
//    public Hero readOne(@PathVariable("idHero") int id){
//        return heroService.findById(id);
//    }
//    
//    @RequestMapping(method = RequestMethod.GET, value="/", params = {"name"})
//    @CrossOrigin(origins = "http://localhost:4200")
//    public Collection<Hero> searchSome(@RequestParam("name") String term){
//        
//        return heroService.findByNameContainig(term);
//    }
}
