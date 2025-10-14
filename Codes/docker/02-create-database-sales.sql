CREATE USER "pg-tickets-sales" WITH PASSWORD 'tickets-sales-password';

CREATE DATABASE "tickets-sales";

ALTER DATABASE "tickets-sales" OWNER TO "pg-tickets-sales";