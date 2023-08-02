package giuseppe.BackEndEs18.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import giuseppe.BackEndEs18.entities.Postazione;
import giuseppe.BackEndEs18.entities.PostazioneRequestPayload;
import giuseppe.BackEndEs18.service.PostazioneService;

@RestController
@RequestMapping("/postazione")
public class PostazioneController {
	private final PostazioneService postazioneSrv;

	@Autowired
	public PostazioneController(PostazioneService postazioneSrv) {
		super();
		this.postazioneSrv = postazioneSrv;
	}

	@GetMapping
	public Page<Postazione> getPostazione(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String sortBy) {
		return postazioneSrv.find(page, size, sortBy);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Postazione savePostazione(@RequestBody PostazioneRequestPayload body) {
		Postazione created = postazioneSrv.create(body);

		return created;
	}

	@GetMapping("/{postazioneId}")
	public Postazione findById(@PathVariable Long postazioneId) {
		return postazioneSrv.findById(postazioneId);

	}

	@PutMapping("/{postazioneId}")
	public Postazione updateUser(@PathVariable Long postazioneId, @RequestBody PostazioneRequestPayload body) {
		return postazioneSrv.findByIdAndUpdate(postazioneId, body);
	}

	@DeleteMapping("/{postazioneId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable Long postazioneId) {
		postazioneSrv.findByIdAndDelete(postazioneId);
	}
}
