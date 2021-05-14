package br.inatel.matrix.RedeSocialPets2.dto;

import br.inatel.matrix.RedeSocialPets2.model.Usuario;

public class UsuarioDto {
	private long id;
	private String nome;
	private String email;

	public UsuarioDto(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
	}

	public String getNome() {
		return nome;
	}

	public long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}