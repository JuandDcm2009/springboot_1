CREATE TABLE ventas(
    id INT PRIMARY KEY AUTO_INCREMENT,
    cedula_cliente VARCHAR(50) NOT NULL,
    cedula_vendedor VARCHAR(50) NOT NULL,
    total DECIMAL(10, 2) NOT NULL
);

CREATE TABLE detalle_venta(
    id INT PRIMARY KEY AUTO_INCREMENT,
    producto INT NOT NULL,
    cantidad INT NOT NULL,
    venta_id INT NOT NULL,
    subtotal DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY(producto) REFERENCES  productos(id),
    FOREIGN KEY(venta_id) REFERENCES  ventas(id)
);


