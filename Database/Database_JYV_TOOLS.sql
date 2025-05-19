create database JYV_TOOLS;
use JYV_TOOLS;

CREATE TABLE roles (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50)
);

CREATE TABLE localidades (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT
);


CREATE TABLE usuarios (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombre1 VARCHAR(100) NOT NULL,
    nombre2 VARCHAR(100),
    apellido1 VARCHAR(100) NOT NULL,
    apellido2 VARCHAR(100),
    correo VARCHAR(100) UNIQUE NOT NULL,
    id_rol INT UNSIGNED NOT NULL,
    id_localidad INT UNSIGNED NOT NULL,
    telefono VARCHAR(20),
    direccion VARCHAR(100),
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_rol) REFERENCES roles(id),
    FOREIGN KEY (id_localidad) REFERENCES localidades(id)
);

CREATE TABLE detalles_proveedores (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT UNSIGNED NOT NULL,
    nit VARCHAR(20) UNIQUE NOT NULL,
    nombre_empresa VARCHAR(100) NOT NULL,
    direccion VARCHAR(150),
    telefono VARCHAR(20),
    correo_electronico VARCHAR(100),
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
);


CREATE TABLE reportes_generales (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT UNSIGNED NOT NULL,
    fecha_reporte TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    ingreso DECIMAL(10,2),
    Herramienta_Mas_alquilado VARCHAR(50),
    Total_alquiler INT,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
);

CREATE TABLE estados (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);


CREATE TABLE categorias (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    descripcion TEXT
);


CREATE TABLE herramientas (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    id_categoria INT UNSIGNED NOT NULL,
    id_estado INT UNSIGNED NOT NULL,
    imagen_url VARCHAR(255),
    FOREIGN KEY (id_categoria) REFERENCES categorias(id),
    FOREIGN KEY (id_estado) REFERENCES estados(id)
);


CREATE TABLE detalles_herramientas (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    id_herramienta INT UNSIGNED NOT NULL,
    marca VARCHAR(50),
    modelo VARCHAR(50),
    precio_diario DECIMAL(10, 2) NOT NULL,
    descripcion VARCHAR(50),
    FOREIGN KEY (id_herramienta) REFERENCES herramientas(id)
);


CREATE TABLE inventario (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    id_proveedor INT UNSIGNED NOT NULL,
    fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    Stock INT DEFAULT 0,
    id_herramienta INT UNSIGNED NOT NULL,
    FOREIGN KEY (id_herramienta) REFERENCES herramientas(id),
    FOREIGN KEY (id_proveedor) REFERENCES usuarios(id)
);


CREATE TABLE herramientas_mantenimientos (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    id_herramienta INT UNSIGNED NOT NULL,
    fecha_mantenimiento TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    descripcion TEXT NOT NULL,
    costo DECIMAL(10, 2),
    FOREIGN KEY (id_herramienta) REFERENCES herramientas(id)
);


CREATE TABLE reservas (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT UNSIGNED NOT NULL,
    id_herramienta INT UNSIGNED NOT NULL,
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE NOT NULL,
    estado_de_reservacion VARCHAR(50),
    costo_total DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES usuarios(id),
    FOREIGN KEY (id_herramienta) REFERENCES herramientas(id)
);


CREATE TABLE alquiler (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    reserva_id INT UNSIGNED NOT NULL,
    fecha_alquiler DATE NOT NULL,
    fecha_esperada DATE NOT NULL,
    estado VARCHAR(50),
    fecha_entrega TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (reserva_id) REFERENCES reservas(id)
);


CREATE TABLE devoluciones (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    id_alquiler INT UNSIGNED UNIQUE NOT NULL,
    fecha_devolucion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estado_herramienta VARCHAR(50),
    comentarios TEXT,
    FOREIGN KEY (id_alquiler) REFERENCES alquiler(id)
);


CREATE TABLE multas_daños (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    id_reserva INT UNSIGNED NOT NULL,
    descripcion TEXT NOT NULL,
    costo DECIMAL(10, 2) NOT NULL,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_reserva) REFERENCES reservas(id)
);


CREATE TABLE formas_de_pago (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Metodo_pago VARCHAR(50) NOT NULL
);


CREATE TABLE pagos (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    id_estado INT UNSIGNED NOT NULL,
    id_reserva INT UNSIGNED UNIQUE NOT NULL,
    id_forma_pago INT UNSIGNED NOT NULL,
    monto DECIMAL(10, 2) NOT NULL,
    fecha_pago TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_estado) REFERENCES estados(id),
    FOREIGN KEY (id_reserva) REFERENCES reservas(id),
    FOREIGN KEY (id_forma_pago) REFERENCES formas_de_pago(id)
);


CREATE TABLE facturas (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    id_pago INT UNSIGNED UNIQUE NOT NULL,
    numero_factura VARCHAR(50) UNIQUE NOT NULL,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    monto_total DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (id_pago) REFERENCES pagos(id)
);


CREATE TABLE detalles_factura (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    id_factura INT UNSIGNED NOT NULL,
    Cantidad INT NOT NULL,
    descripcion TEXT NOT NULL,
    monto_unitario DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (id_factura) REFERENCES facturas(id)
);


CREATE TABLE notificaciones (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT UNSIGNED NOT NULL,
    id_alquiler INT UNSIGNED NOT NULL,
    mensaje TEXT NOT NULL,
    fecha_envio TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    leida BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id),
    FOREIGN KEY (id_alquiler) REFERENCES alquiler(id)
);


CREATE TABLE entregas (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    estado VARCHAR(50),
    id_alquiler INT UNSIGNED UNIQUE NOT NULL,
    direccion_entrega VARCHAR(100) NOT NULL,
    fecha_entrega TIMESTAMP NOT NULL,
    costo_entrega DECIMAL(10, 2),
    FOREIGN KEY (id_alquiler) REFERENCES alquiler(id)
);
