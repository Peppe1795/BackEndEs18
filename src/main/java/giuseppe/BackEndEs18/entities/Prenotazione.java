package giuseppe.BackEndEs18.entities;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Prenotazione {
	@Id
	private UUID id;
	@ManyToOne
	private User user;
	@ManyToOne
	private Postazione postazione;
	private LocalDate dataPrenotazione;
	private LocalDate scadenza;
}
