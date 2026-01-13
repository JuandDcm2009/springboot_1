CREATE TABLE libros(
    id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    autor_id_fk INT NOT NULL,
    FOREIGN KEY(autor_id_fk) REFERENCES autores(id)
);

CREATE TABLE autores(
    id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    cedula VARCHAR(20) NOT NULL,
    edad INT NOT NULL
);