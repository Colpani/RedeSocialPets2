package br.inatel.matrix.RedeSocialPets2.dto;

import java.time.LocalDateTime;

import br.inatel.matrix.RedeSocialPets2.model.Postagem;

public class DetalhesPostagemDto {

	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime dataCriacao;
	private String nomeAutor;
	
	public DetalhesPostagemDto(Postagem postagem) {
		this.id = postagem.getId();
		this.titulo = postagem.getTitulo();
		this.mensagem = postagem.getMensagem();
		this.dataCriacao = postagem.getDataCriacao();
		this.nomeAutor = postagem.getAutor().getNome();
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}
	
}
