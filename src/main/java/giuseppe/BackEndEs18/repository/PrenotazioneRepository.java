package giuseppe.BackEndEs18.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import giuseppe.BackEndEs18.entities.Prenotazione;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, UUID> {

}
