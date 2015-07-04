
CREATE TABLE public.rol (
                id INTEGER NOT NULL,
                nombre VARCHAR NOT NULL,
                CONSTRAINT rol_primary_key PRIMARY KEY (id)
);


CREATE TABLE public.usuario (
                id INTEGER NOT NULL,
                nombre VARCHAR(50) NOT NULL,
                correo VARCHAR(100) NOT NULL,
                apellidos VARCHAR(100) NOT NULL,
                clave VARCHAR NOT NULL,
                foto VARCHAR NOT NULL,
                rol_id INTEGER NOT NULL,
                CONSTRAINT usuario_primary_key PRIMARY KEY (id)
);


CREATE TABLE public.categoria (
                id INTEGER NOT NULL,
                nombre VARCHAR NOT NULL,
                CONSTRAINT categoria_primary_key PRIMARY KEY (id)
);


CREATE TABLE public.publicacion (
                id INTEGER NOT NULL,
                titulo VARCHAR(60) NOT NULL,
                contenido TEXT NOT NULL,
                descripcion VARCHAR(100) NOT NULL,
                fecha_publicacion TIMESTAMP NOT NULL,
                banner_small VARCHAR NOT NULL,
                banner_large VARCHAR NOT NULL,
                categoria_id INTEGER NOT NULL,
                autor_id INTEGER NOT NULL,
                CONSTRAINT publicacion_primary_key PRIMARY KEY (id)
);


CREATE SEQUENCE public.publicacion_categoria_id_sequence;

CREATE TABLE public.publicacion_categoria (
                id INTEGER NOT NULL DEFAULT nextval('public.publicacion_categoria_id_sequence'),
                publicacion_id INTEGER NOT NULL,
                categoria_id INTEGER NOT NULL,
                CONSTRAINT publicacion_categoria_primary_key PRIMARY KEY (id)
);


ALTER SEQUENCE public.publicacion_categoria_id_sequence OWNED BY public.publicacion_categoria.id;

ALTER TABLE public.usuario ADD CONSTRAINT rol_usuario_fk
FOREIGN KEY (rol_id)
REFERENCES public.rol (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.publicacion ADD CONSTRAINT usuario_publicacion_fk
FOREIGN KEY (autor_id)
REFERENCES public.usuario (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.publicacion ADD CONSTRAINT categoria_publicacion_fk
FOREIGN KEY (categoria_id)
REFERENCES public.categoria (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.publicacion ADD CONSTRAINT categoria_publicacion_fk1
FOREIGN KEY (categoria_id)
REFERENCES public.categoria (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.publicacion_categoria ADD CONSTRAINT categoria_publicacion_categoria_fk
FOREIGN KEY (categoria_id)
REFERENCES public.categoria (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.publicacion_categoria ADD CONSTRAINT publicacion_publicacion_categoria_fk
FOREIGN KEY (publicacion_id)
REFERENCES public.publicacion (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
