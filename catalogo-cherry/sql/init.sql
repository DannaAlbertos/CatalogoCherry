-- 1) En pgAdmin (Query Tool) conectado a la base "postgres":
CREATE DATABASE catalogo_cherry;

-- 2) Arranca la app una vez (Spring crea la tabla "dresses" solo).
-- 3) Conectate a catalogo_cherry y, si quieres datos de ejemplo, ejecuta:
INSERT INTO dresses (name, description, category, size, color, price, stock, image_url, available) VALUES
('Vestido Rosa Floral', 'Vestido midi con estampado floral, ideal para primavera', 'Casual', 'M', 'Rosa', 899.00, 10, 'https://ejemplo.com/rosa.jpg', true),
('Vestido Negro Elegante', 'Vestido largo de noche con espalda descubierta', 'Fiesta', 'S', 'Negro', 1850.00, 4, 'https://ejemplo.com/negro.jpg', true),
('Vestido Rojo Cocktail', 'Vestido corto entallado para eventos', 'Cocktail', 'L', 'Rojo', 1290.50, 6, 'https://ejemplo.com/rojo.jpg', true);
