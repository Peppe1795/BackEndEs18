package giuseppe.BackEndEs18.entities;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Prenotazione {
	@Id
	@GeneratedValue
	private UUID id;
	@ManyToOne
	private User user;
	@ManyToOne
	private Postazione postazione;
	private LocalDate dataPrenotazione;
	private LocalDate scadenza;

	public Prenotazione(User user, Postazione postazione, LocalDate dataPrenotazione, LocalDate scadenza) {
		super();
		this.user = user;
		this.postazione = postazione;
		this.dataPrenotazione = dataPrenotazione;
		this.scadenza = scadenza;
	}
}