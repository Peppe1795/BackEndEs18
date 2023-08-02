package giuseppe.BackEndEs18.entities;

import jakarta.persistence.Entity;
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
public class User {

	@Id
	@GeneratedValue
	private int id;
	private String username;
	private String nomeCompleto;
	private String email;

	public User(String username, String nomeCompleto, String email) {
		this.username = username;
		this.nomeCompleto = nomeCompleto;
		this.email = email;
	}

}
