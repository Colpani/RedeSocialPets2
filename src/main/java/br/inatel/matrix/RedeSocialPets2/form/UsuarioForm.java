package br.inatel.matrix.RedeSocialPets2.form;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.sun.istack.NotNull;

import br.inatel.matrix.RedeSocialPets2.model.Usuario;

public class UsuarioForm {

	@NotNull
	private String name;
	@NotNull 
	private String email;
	@NotNull
	private String password;

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public Usuario convert() {
		String encryptedPassword = new BCryptPasswordEncoder().encode(password);
		return new Usuario(name, email, encryptedPassword);
	}

}
