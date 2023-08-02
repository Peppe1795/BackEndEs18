package giuseppe.BackEndEs18.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserRequestPayload {
	private String username;
	private String nomeCompleto;
	private String email;
}
