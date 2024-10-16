FROM mcr.microsoft.com/mssql/server:2022-latest

ENV ACCEPT_EULA=Y
ENV MSSQL_PID=Express

USER root

RUN --mount=type=secret,id=MSSQL_SA_PASSWORD,required=true \
    mkdir -p /run/secrets && \
    cp /run/secrets/MSSQL_SA_PASSWORD /tmp/sa_password.txt && \
    chmod 644 /tmp/sa_password.txt && \
    chown mssql:mssql /tmp/sa_password.txt

COPY ./vacunas-init.sql /usr/src/app/setup.sql
COPY ./configure-db.sh /usr/src/app/configure-db.sh

RUN chmod +x /usr/src/app/configure-db.sh

USER mssql

RUN /bin/bash /usr/src/app/configure-db.sh

EXPOSE 1433

CMD ["/opt/mssql/bin/sqlservr"]