CREATE USER "pg-tickets-notification" WITH PASSWORD 'tickets-notification-password';

CREATE DATABASE "tickets-notification";
ALTER DATABASE "tickets-notification" OWNER TO "pg-tickets-notification";