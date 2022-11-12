package ubilapaz.edu.bo.template.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ubilapaz.edu.bo.template.domain.Libro;

@Repository
public interface LibroJpaRepository extends JpaRepository<Libro,Integer> {

}
