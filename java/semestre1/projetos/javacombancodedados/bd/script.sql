CREATE SCHEMA tads;

USE tads;

DROP TABLE usuario;

CREATE TABLE usuario(
	id INT AUTO_INCREMENT PRIMARY KEY, 
    nome VARCHAR(100) NOT NULL,
    login VARCHAR(20) NOT NULL UNIQUE,
    senha VARCHAR(10) NOT NULL, -- sha256 md5
    email VARCHAR(100) NOT NULL,
    perfil INT NOT NULL,
    CONSTRAINT fk_usuario_perfil FOREIGN KEY (perfil) REFERENCES perfil (id)
);

CREATE TABLE perfil(
	id INT AUTO_INCREMENT PRIMARY KEY,
    nivel VARCHAR(10) NOT NULL
);

SHOW TABLES;


SELECT * FROM usuario;

INSERT INTO perfil (id, nivel)
		VALUES (NULL, "ADM"),
		       (NULL, "Professor"),
               (NULL, "Estudante");
               
SELECT * FROM perfil;


UPDATE perfil
SET nivel = "ADM"
WHERE id = 1;

INSERT INTO usuario (id, nome, login, senha, email, perfil)
	VALUES (null, "Neto", "neto", "1234", "neto@neto.pro.br", 1);


SELECT u.id, u.nome, u.login, u.email, p.nivel
FROM usuario u
	 JOIN perfil p ON (u.perfil = p.id);
