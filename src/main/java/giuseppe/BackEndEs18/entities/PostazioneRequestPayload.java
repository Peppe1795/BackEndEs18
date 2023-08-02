package giuseppe.BackEndEs18.entities;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostazioneRequestPayload {
	private String descrizione;
	@Enumerated(EnumType.STRING)
	private TipoPostazione tipoPostazione;
	private int numeroOccupantiMax;
	private String citta;
}
