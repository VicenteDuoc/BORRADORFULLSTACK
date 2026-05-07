INSERT INTO carrito (usuario_id, total, fecha_agregado) VALUES
(1, 0.0, NOW()),
(2, 0.0, NOW());

INSERT INTO detalle_carrito (juego_id, nombre_juego, cantidad, precio_unitario, subtotal, carrito_id) VALUES
(1, 'God of War', 1, 59.99, 59.99, 1),
(2, 'Spider-Man 2', 2, 49.99, 99.98, 1),
(3, 'Hogwarts Legacy', 1, 39.99, 39.99, 2);