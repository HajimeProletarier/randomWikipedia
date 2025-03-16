#!/bin/bash
exec /usr/local/tomcat/bin/catalina.sh run -DDB_HOST=$DB_HOST -DDB_PORT=$DB_PORT -DDB_NAME=$DB_NAME -DDB_USERNAME=$DB_USERNAME -DDB_PASSWORD=$DB_PASSWORD

