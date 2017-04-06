package com.mycompany.Service;

import com.mycompany.domain.Hero;
import java.util.Collection;

/**
 *
 * @author gduvinage
 */
public interface HeroService {
    Collection<Hero> findAll();
    Collection<Hero> findByNameContainig(String term);
    Hero findById(Integer id);
}
