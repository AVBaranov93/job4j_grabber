create table if not exists post(
id serial primary key,
	name text,
	text text not null,
	link text not null unique,
	created timestamp not null
);