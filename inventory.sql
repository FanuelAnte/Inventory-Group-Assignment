DROP DATABASE IF EXISTS inventory;

CREATE DATABASE inventory;

\connect inventory

CREATE TABLE public.unit (
	code varchar(5) NOT NULL,
	"name" varchar(20) NOT NULL,
	id int4 NOT NULL GENERATED ALWAYS AS IDENTITY,
	CONSTRAINT unit_pk PRIMARY KEY (id)
);

CREATE TABLE public.product_group (
	id int4 NOT NULL GENERATED ALWAYS AS IDENTITY,
	code varchar NOT NULL,
	"name" varchar NOT NULL,
	CONSTRAINT product_group_pk PRIMARY KEY (id)
);

CREATE TABLE public.product (
	id int4 NOT NULL GENERATED ALWAYS AS IDENTITY,
	code varchar NOT NULL,
	"name" varchar NOT NULL,
	unit_price float4 NOT NULL,
	quantity float4 NOT NULL,
	unit_id int4 NOT NULL,
	product_group_id int4 NOT NULL,
	CONSTRAINT product_pk PRIMARY KEY (id)
);


-- public.product foreign keys

ALTER TABLE public.product ADD CONSTRAINT product_fk FOREIGN KEY (unit_id) REFERENCES public.unit(id);
ALTER TABLE public.product ADD CONSTRAINT product_fk_1 FOREIGN KEY (product_group_id) REFERENCES public.product_group(id);


CREATE TABLE public.sale (
	id int4 NOT NULL GENERATED ALWAYS AS IDENTITY,
	sale_date date NOT NULL,
	quantity float4 NOT NULL,
	total_price float4 NOT NULL,
	product_id int4 NOT NULL,
	CONSTRAINT sale_pk PRIMARY KEY (id)
);


-- public.sale foreign keys

ALTER TABLE public.sale ADD CONSTRAINT sale_fk FOREIGN KEY (product_id) REFERENCES public.product(id);

CREATE TABLE public.purchase (
	id int4 NOT NULL GENERATED ALWAYS AS IDENTITY,
	purchase_date date NOT NULL,
	quantity float4 NOT NULL,
	total_price float4 NOT NULL,
	product_id int4 NOT NULL,
	CONSTRAINT purchase_pk PRIMARY KEY (id)
);


-- public.purchase foreign keys

ALTER TABLE public.purchase ADD CONSTRAINT purchase_fk FOREIGN KEY (product_id) REFERENCES public.product(id);
