delete from public.detalle_factura;

delete from public.facturas;

DELETE FROM public.productos;

DELETE FROM public.proveedores;

delete from public.clientes ;

DELETE FROM public.usuario;

INSERT INTO public.usuario
(id, contrasenia, estado, usuario_login, nombre)
VALUES(1, 'herher', 'A', 'hernan', 'Hernan Inga');

INSERT INTO public.usuario
(id, contrasenia, estado, usuario_login, nombre)
VALUES(2, 'adminadmin', 'A', 'admin', 'Administrador');



INSERT INTO public.clientes
(id_cliente, apellido, create_at, email, nombre)
VALUES(1, 'Torres', '2024-01-23 00:00:00.000', 'admin@mail.com', 'Dario');
INSERT INTO public.clientes
(id_cliente, apellido, create_at, email, nombre)
VALUES(2, 'Lopez', '2024-01-23 00:00:00.000', 'prueba@mail.com', 'Juan Jose');
INSERT INTO public.clientes
(id_cliente, apellido, create_at, email, nombre)
VALUES(3, 'Lopez', '2024-01-23 00:00:00.000', 'admin@mail.com', 'Alexandra');
INSERT INTO public.clientes
(id_cliente, apellido, create_at, email, nombre)
VALUES(4, 'Guaman', '2024-01-23 00:00:00.000', 'prueba@mail.com', 'Diana');
INSERT INTO public.clientes
(id_cliente, apellido, create_at, email, nombre)
VALUES(5, 'Garcez', '2024-01-23 00:00:00.000', 'dario@mail.com', 'Dario');
INSERT INTO public.clientes
(id_cliente, apellido, create_at, email, nombre)
VALUES(6, 'Lopez', '2024-01-23 00:00:00.000', 'prueba@mail.com', 'Juan Jose');
INSERT INTO public.clientes
(id_cliente, apellido, create_at, email, nombre)
VALUES(7, 'Tumi', '2024-01-23 00:00:00.000', 'admin@mail.com', 'Alexandra');
INSERT INTO public.clientes
(id_cliente, apellido, create_at, email, nombre)
VALUES(8, 'Guaman', '2024-01-23 00:00:00.000', 'prueba@mail.com', 'Diana');




INSERT INTO public.proveedores
(id_proveedor, create_at, direccion, nombre)
VALUES(1, '2024-01-25 00:00:00.000', 'Carcelen', 'Dristribuidora Jonh');

INSERT INTO public.proveedores
(id_proveedor, create_at, direccion, nombre)
VALUES(2, '2024-01-25 00:00:00.000', 'San Jose', 'Abastos S.A.');

INSERT INTO public.proveedores
(id_proveedor, create_at, direccion, nombre)
VALUES(3, '2024-01-25 00:00:00.000', 'Solanda', 'Distribucion S.A.');

INSERT INTO public.proveedores
(id_proveedor, create_at, direccion, nombre)
VALUES(4, '2024-01-25 00:00:00.000', 'Ibarra', 'Pulidora Jonh');




INSERT INTO public.productos
(id_producto, create_at, nombre, stock, valor_unitario, id_proveedor)
VALUES(1, '2024-01-27 00:00:00.000', 'Producto 1', '10', 11.25, 1);
INSERT INTO public.productos
(id_producto, create_at, nombre, stock, valor_unitario, id_proveedor)
VALUES(2, '2024-01-27 00:00:00.000', 'Producto 2', '10', 2.25, 1);
INSERT INTO public.productos
(id_producto, create_at, nombre, stock, valor_unitario, id_proveedor)
VALUES(3, '2024-01-27 00:00:00.000', 'Producto 4', '10', 123.25, 1);
INSERT INTO public.productos
(id_producto, create_at, nombre, stock, valor_unitario, id_proveedor)
VALUES(4, '2024-01-27 00:00:00.000', 'Producto 5', '10', 45.25, 2);
INSERT INTO public.productos
(id_producto, create_at, nombre, stock, valor_unitario, id_proveedor)
VALUES(5, '2024-01-27 00:00:00.000', 'Producto 6', '10', 7.25, 2);
INSERT INTO public.productos
(id_producto, create_at, nombre, stock, valor_unitario, id_proveedor)
VALUES(6, '2024-01-27 00:00:00.000', 'Producto 8', '10', 9.25, 2);
INSERT INTO public.productos
(id_producto, create_at, nombre, stock, valor_unitario, id_proveedor)
VALUES(7, '2024-01-27 00:00:00.000', 'Producto 17', '10', 11.25, 3);
INSERT INTO public.productos
(id_producto, create_at, nombre, stock, valor_unitario, id_proveedor)
VALUES(8, '2024-01-27 00:00:00.000', 'Producto 28', '10', 2.25, 3);
INSERT INTO public.productos
(id_producto, create_at, nombre, stock, valor_unitario, id_proveedor)
VALUES(9, '2024-01-27 00:00:00.000', 'Producto 47', '10', 123.25, 3);
INSERT INTO public.productos
(id_producto, create_at, nombre, stock, valor_unitario, id_proveedor)
VALUES(10, '2024-01-27 00:00:00.000', 'Producto 56', '10', 45.25, 4);
INSERT INTO public.productos
(id_producto, create_at, nombre, stock, valor_unitario, id_proveedor)
VALUES(11, '2024-01-27 00:00:00.000', 'Producto 64', '10', 7.25, 4);
INSERT INTO public.productos
(id_producto, create_at, nombre, stock, valor_unitario, id_proveedor)
VALUES(12, '2024-01-27 00:00:00.000', 'Producto 84', '10', 9.25, 4);



INSERT INTO public.facturas
(id, create_at, estado, numero_factura, total, id_cliente, id_proveedor)
VALUES(1, '2024-01-27 00:00:00.000', 'A', 'F-001', 20.0, 1, 1);



INSERT INTO public.detalle_factura
(id_det, cantidad, create_at, subtotal, valor_iva, id, id_producto)
VALUES(1, 2, '2024-01-27 00:00:00.000', 20.0, 2.0, 1, 1);
INSERT INTO public.detalle_factura
(id_det, cantidad, create_at, subtotal, valor_iva, id, id_producto)
VALUES(2, 1, '2024-01-27 00:00:00.000', 10.0, 1.0, 1, 3);










