CREATE TABLE carrito(
    id BIGINT AUTO_INCREMENT PRIMARY KEY
    usuario_Id BIGINT NOT NULL,
    juego_Id BIGINT NOT NULL,
    nombre_juego VARCHAR(255) NOT NULL,
    cantidad INT NOT NULL,
    precio_unitario DOUBLE NOT NULL,
    subtotal DOUBLE NOT NULL,
    fecha_agregado DATETIME
);