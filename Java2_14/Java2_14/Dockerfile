FROM postgres:latest

ENV POSTGRES_USER=myuser
ENV POSTGRES_PASSWORD=mypassword
ENV POSTGRES_DB=mydatabase

COPY src/main/resources/database/init.sql /docker-entrypoint-initdb.d/

CMD ["postgres"]
