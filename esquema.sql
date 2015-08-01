
CREATE TABLE public.UserConnection (
                providerId VARCHAR(255) NOT NULL,
                userId VARCHAR(255) NOT NULL,
                providerUserId VARCHAR(255) NOT NULL,
                rank INTEGER NOT NULL,
                profileUrl VARCHAR,
                displayName VARCHAR(255),
                accessToken VARCHAR(255) NOT NULL,
                secret VARCHAR(255),
                refreshToken VARCHAR(255) NOT NULL,
                expireTime BIGINT,
                imageUrl VARCHAR,
                CONSTRAINT userconnection_pk PRIMARY KEY (providerId, userId, providerUserId)
);


CREATE SEQUENCE public.rol_id_seq;

CREATE TABLE public.rol (
                id INTEGER NOT NULL DEFAULT nextval('public.rol_id_seq'),
                nombre VARCHAR(40) NOT NULL,
                CONSTRAINT rol_primary_key PRIMARY KEY (id)
);


ALTER SEQUENCE public.rol_id_seq OWNED BY public.rol.id;

CREATE SEQUENCE public.usuario_id_seq;

CREATE TABLE public.usuario (
                id INTEGER NOT NULL DEFAULT nextval('public.usuario_id_seq'),
                nombre VARCHAR(50) NOT NULL,
                correo VARCHAR(100) NOT NULL,
                apellidos VARCHAR(100) NOT NULL,
                clave VARCHAR,
                foto VARCHAR,
                providerId VARCHAR(255),
                providerUserId VARCHAR(255),
                rol_id INTEGER NOT NULL,
                CONSTRAINT usuario_primary_key PRIMARY KEY (id)
);


ALTER SEQUENCE public.usuario_id_seq OWNED BY public.usuario.id;

CREATE SEQUENCE public.noticia_id_seq;

CREATE TABLE public.noticia (
                id INTEGER NOT NULL DEFAULT nextval('public.noticia_id_seq'),
                titulo VARCHAR(250) NOT NULL,
                contenido VARCHAR NOT NULL,
                descripcion VARCHAR NOT NULL,
                enlace VARCHAR NOT NULL,
                fecha_publicacion TIMESTAMP NOT NULL,
                banner_small VARCHAR NOT NULL,
                banner_large VARCHAR NOT NULL,
                usuario_id INTEGER NOT NULL,
                CONSTRAINT noticia_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.noticia_id_seq OWNED BY public.noticia.id;

CREATE SEQUENCE public.categoria_id_seq;

CREATE TABLE public.categoria (
                id INTEGER NOT NULL DEFAULT nextval('public.categoria_id_seq'),
                nombre VARCHAR(60) NOT NULL,
                enlace VARCHAR NOT NULL,
                CONSTRAINT categoria_primary_key PRIMARY KEY (id)
);


ALTER SEQUENCE public.categoria_id_seq OWNED BY public.categoria.id;

CREATE SEQUENCE public.noticia_categoria_id_seq_1;

CREATE TABLE public.noticia_categoria (
                id INTEGER NOT NULL DEFAULT nextval('public.noticia_categoria_id_seq_1'),
                noticia_id INTEGER NOT NULL,
                categoria_id INTEGER NOT NULL,
                CONSTRAINT publicacion_categoria_primary_key PRIMARY KEY (id)
);


ALTER SEQUENCE public.noticia_categoria_id_seq_1 OWNED BY public.noticia_categoria.id;

ALTER TABLE public.usuario ADD CONSTRAINT rol_usuario_fk
FOREIGN KEY (rol_id)
REFERENCES public.rol (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.noticia ADD CONSTRAINT usuario_noticia_fk
FOREIGN KEY (usuario_id)
REFERENCES public.usuario (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.noticia_categoria ADD CONSTRAINT noticia_noticia_categoria_fk
FOREIGN KEY (noticia_id)
REFERENCES public.noticia (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.noticia_categoria ADD CONSTRAINT categoria_noticia_categoria_fk
FOREIGN KEY (categoria_id)
REFERENCES public.categoria (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;