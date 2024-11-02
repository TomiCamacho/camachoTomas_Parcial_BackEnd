package org.demo.parcialCamachoTomas.repositorios;

import org.demo.parcialCamachoTomas.entidades.Adn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AdnRepository extends JpaRepository<Adn, Long> {

    Optional<Adn> findByAdn(String adnSequence);
    long countByIsMutant(boolean isMutant);

}
