CREATE TABLE pedidos(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    usuario_Id BIGINT NOT NULL,
    producto VARCHAR(255) NOT NULL,
    cantidad INT NOT NULL,
    total DOUBLE NOT NULL,
    estado VARCHAR(50) NOT NULL,
    fecha_pedido DATETIME,
    fecha_entrega DATETIME
);