package giuseppe.BackEndEs18.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Postazione {
	@Id
	@GeneratedValue
	private Long id;
	private String descrizione;
	@Enumerated(EnumType.STRING)
	private TipoPostazione tipoPostazione;
	private int numeroOccupantiMax;
	private String citta;

	public Postazione(String descrizione, TipoPostazione tipoPostazione, int numeroOccupantiMax, String citta) {
		super();
		this.descrizione = descrizione;
		this.tipoPostazione = tipoPostazione;
		this.numeroOccupantiMax = numeroOccupantiMax;
		this.citta = citta;
	}

}
