# Use the latest MySQL image
FROM mysql

# Set the working directory
WORKDIR /tmp

# Copy the main SQL file to docker-entrypoint-initdb.d.
COPY world.sql /docker-entrypoint-initdb.d

# Scripts and SQL files in this folder are executed on container startup.

# Set the root password
ENV MYSQL_ROOT_PASSWORD example