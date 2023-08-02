package giuseppe.BackEndEs18.Exception;

import java.util.UUID;

public class NotFoundExceptionUUid extends RuntimeException {
	public NotFoundExceptionUUid(String message) {
		super(message);
	}

	public NotFoundExceptionUUid(UUID id) {
		super(id + " non trovato!");
	}
}
