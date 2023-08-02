package giuseppe.BackEndEs18.entities;

import java.time.LocalDate;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PrenotazioneRequestPayload {
	@ManyToOne
	private User user;
	@ManyToOne
	private Postazione postazione;
	private LocalDate dataPrenotazione;
	private LocalDate scadenza;
}
