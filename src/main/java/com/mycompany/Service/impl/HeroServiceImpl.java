package com.mycompany.service.impl;

import com.mycompany.Service.HeroService;
import com.mycompany.domain.Hero;
import com.mycompany.repository.HeroRepository;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gduvinage
 */
@Service
public class HeroServiceImpl implements HeroService {

    @Autowired
    HeroRepository heroRepository;

    @Override
    public Collection<Hero> findAll() {
        return heroRepository.findAll();
    }

    @Override
    public Collection<Hero> findByNameContainig(String term) {
        return heroRepository.findByNameContaining(term);
    }
    
    @Override
    public Hero findById(Integer id) {
       return heroRepository.findOne(id);
    }
    

}
