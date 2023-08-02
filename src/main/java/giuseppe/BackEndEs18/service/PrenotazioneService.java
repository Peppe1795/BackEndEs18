package giuseppe.BackEndEs18.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import giuseppe.BackEndEs18.Exception.NotFoundExceptionUUid;
import giuseppe.BackEndEs18.entities.Prenotazione;
import giuseppe.BackEndEs18.entities.PrenotazioneRequestPayload;
import giuseppe.BackEndEs18.repository.PrenotazioneRepository;

@Service
public class PrenotazioneService {
	private final PrenotazioneRepository prenotazioneRepo;

	@Autowired
	public PrenotazioneService(PrenotazioneRepository prenotazioneRepo) {
		this.prenotazioneRepo = prenotazioneRepo;
	}

	public Prenotazione create(PrenotazioneRequestPayload body) {
		Prenotazione newPrenot = new Prenotazione(body.getUser(), body.getPostazione(), body.getDataPrenotazione(),
				body.getScadenza());
		return prenotazioneRepo.save(newPrenot);
	}

	public Page<Prenotazione> find(int page, int size, String sort) {
		Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
		return prenotazioneRepo.findAll(pageable);
	}

	public Prenotazione findById(UUID id) throws NotFoundExceptionUUid {
		return prenotazioneRepo.findById(id).orElseThrow(() -> new NotFoundExceptionUUid(id));
	}

	public Prenotazione findByIdAndUpdate(UUID id, PrenotazioneRequestPayload body) throws NotFoundExceptionUUid {
		Prenotazione found = this.findById(id);
		found.setUser(body.getUser());
		found.setPostazione(body.getPostazione());
		found.setDataPrenotazione(body.getDataPrenotazione());
		found.setScadenza(body.getScadenza());

		return prenotazioneRepo.save(found);
	}

	public void findByIdAndDelete(UUID id) throws NotFoundExceptionUUid {
		Prenotazione found = this.findById(id);
		prenotazioneRepo.delete(found);
	}
}
