package giuseppe.BackEndEs18.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import giuseppe.BackEndEs18.entities.Prenotazione;
import giuseppe.BackEndEs18.entities.PrenotazioneRequestPayload;
import giuseppe.BackEndEs18.service.PrenotazioneService;

@RestController
@RequestMapping("/prenotazione")
public class PrenotazioneController {

	private final PrenotazioneService prenotazioneSrv;

	@Autowired
	public PrenotazioneController(PrenotazioneService prenotazioneSrv) {
		this.prenotazioneSrv = prenotazioneSrv;
	}

	@GetMapping("/rules")
	public ResponseEntity<String> getRegolePrenotazione(@RequestParam String lingua) {
		String testoRegole;
		if ("italiano".equalsIgnoreCase(lingua)) {
			testoRegole = "Regole di prenotazione in italiano";
		} else if ("inglese".equalsIgnoreCase(lingua)) {
			testoRegole = "Booking rules in English";
		} else {
			return ResponseEntity.badRequest().body("Lingua non supportata");
		}
		return ResponseEntity.ok(testoRegole);
	}

	@GetMapping
	public Page<Prenotazione> getUsers(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String sortBy) {
		return prenotazioneSrv.find(page, size, sortBy);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Prenotazione savepre(@RequestBody PrenotazioneRequestPayload body) {
		Prenotazione created = prenotazioneSrv.create(body);

		return created;
	}

	@GetMapping("/{prenotazioneId}")
	public Prenotazione findById(@PathVariable UUID prenotazioneId) {
		return prenotazioneSrv.findById(prenotazioneId);

	}

	@PutMapping("/{prenotazioneId}")
	public Prenotazione updateUser(@PathVariable UUID prenotazioneId, @RequestBody PrenotazioneRequestPayload body) {
		return prenotazioneSrv.findByIdAndUpdate(prenotazioneId, body);
	}

	@DeleteMapping("/{prenotazioneId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable UUID prenotazioneId) {
		prenotazioneSrv.findByIdAndDelete(prenotazioneId);
	}

}
