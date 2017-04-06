package com.mycompany.repository;

import com.mycompany.domain.Hero;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gduvinage
 */
@Repository
public interface HeroRepository extends JpaRepository<Hero, Integer> {
    Collection<Hero> findByNameContaining(String term);
}
