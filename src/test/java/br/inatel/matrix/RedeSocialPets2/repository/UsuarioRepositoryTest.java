package br.inatel.matrix.RedeSocialPets2.repository;

import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.inatel.matrix.RedeSocialPets2.model.Usuario;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE) // necessario por causa do MySQL
class UsuarioRepositoryTest {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Test
	void shouldReturnEmail() {
		String email = "cleber@email.com";
		Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
		Assert.assertEquals(email, usuario.get().getEmail());
	}
}