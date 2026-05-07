CREATE TABLE carrito (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    usuario_id BIGINT NOT NULL,
    total DOUBLE,
    fecha_agregado DATETIME
);

CREATE TABLE detalle_carrito(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    juego_id BIGINT NOT NULL,
    nombre_juego VARCHAR(255) NOT NULL,
    cantidad INT NOT NULL,
    precio_unitario DOUBLE NOT NULL,
    subtotal DOUBLE NOT NULL,
    carrito_id BIGINT NOT NULL,
    FOREIGN KEY (carrito_id) REFERENCES carrito(id)
);