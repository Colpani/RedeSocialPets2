INSERT INTO USUARIO(nome, email, senha) VALUES('Tablito', 'tablito@gato.com', '$2a$10$sFKmbxbG4ryhwPNx/l3pgOJSt.fW1z6YcUnuE2X8APA/Z3NI/oSpq');
INSERT INTO USUARIO(nome, email, senha) VALUES('Gotica', 'gotica@gatona.cat', '$2a$10$sFKmbxbG4ryhwPNx/l3pgOJSt.fW1z6YcUnuE2X8APA/Z3NI/oSpq');

INSERT INTO ANIMAL_CATEGORIA(categoria) VALUES('gato');
INSERT INTO ANIMAL_CATEGORIA(categoria) VALUES('cachorro');

INSERT INTO POSTAGEM(titulo, mensagem, data_criacao, autor_id, animal_id) VALUES('Gato pode comer uva?', 'Uva pode ser prejudicial aos gatos?', '2019-05-05 18:00:00', 1, 1);
INSERT INTO POSTAGEM(titulo, mensagem, data_criacao, autor_id, animal_id) VALUES('Olhem a foto do meu gato!', 'http://url.foto.gato.jpg', '2019-05-05 19:00:00', 1, 1);
INSERT INTO POSTAGEM(titulo, mensagem, data_criacao, autor_id, animal_id) VALUES('Minha vizinha tem um cachorro extraterrestre', 'Ontem, quando fui dormir, percebi que o cachorro da minha vizinha estava brilhando e...', '2019-05-05 20:00:00', 2, 2);