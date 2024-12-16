package ma.enset.keynoteprojet.repositories;

import ma.enset.keynoteprojet.entities.Keynote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeyNoteRepository extends JpaRepository<Keynote, String> {
}
