CREATE USER "pg-tickets-users" WITH PASSWORD 'tickets-users-password';

CREATE DATABASE "tickets-users";

ALTER DATABASE "tickets-users" OWNER TO "pg-tickets-users";