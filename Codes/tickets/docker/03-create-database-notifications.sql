CREATE USER "pg-tickets-notifications" WITH PASSWORD 'tickets-notifications-password';

CREATE DATABASE "tickets-notifications";

ALTER DATABASE "tickets-notifications" OWNER TO "pg-tickets-notifications";