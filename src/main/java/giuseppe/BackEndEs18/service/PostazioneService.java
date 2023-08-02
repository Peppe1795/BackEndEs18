package giuseppe.BackEndEs18.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import giuseppe.BackEndEs18.Exception.NotFoundExceptionLongId;
import giuseppe.BackEndEs18.entities.Postazione;
import giuseppe.BackEndEs18.entities.PostazioneRequestPayload;
import giuseppe.BackEndEs18.repository.PostazioneRepository;

@Service
public class PostazioneService {
	private final PostazioneRepository postazioneRepo;

	@Autowired
	public PostazioneService(PostazioneRepository postazioneRepo) {
		this.postazioneRepo = postazioneRepo;
	}

	public Postazione create(PostazioneRequestPayload body) {
		Postazione newPost = new Postazione(body.getDescrizione(), body.getTipoPostazione(),
				body.getNumeroOccupantiMax(), body.getCitta());
		return postazioneRepo.save(newPost);
	}

	public Page<Postazione> find(int page, int size, String sort) {
		Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
		return postazioneRepo.findAll(pageable);
	}

	public Postazione findById(Long id) throws NotFoundExceptionLongId {
		return postazioneRepo.findById(id).orElseThrow(() -> new NotFoundExceptionLongId(id));
	}

	public Postazione findByIdAndUpdate(Long id, PostazioneRequestPayload body) throws NotFoundExceptionLongId {
		Postazione found = this.findById(id);
		found.setTipoPostazione(body.getTipoPostazione());
		;
		found.setDescrizione(body.getDescrizione());
		found.setNumeroOccupantiMax(body.getNumeroOccupantiMax());
		found.setCitta(body.getCitta());

		return postazioneRepo.save(found);
	}

	public void findByIdAndDelete(Long id) throws NotFoundExceptionLongId {
		Postazione found = this.findById(id);
		postazioneRepo.delete(found);
	}
}
