sudo apt update
sudo apt install postgresql postgresql-

brew install postgresql

sudo systemctl start postgresql
sudo -u postgres psql
CREATE DATABASE ecommerce;

spring.datasource.url=jdbc:postgresql:
spring.datasource.username=postgres
spring.datasource.password=your_password
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
