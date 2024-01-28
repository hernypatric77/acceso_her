# acceso-her
Servicio rest manejo del back-end de la prueba

# Passos a seguir 
1.- Descargarse las fuentes <br>

2.- Configurar base de datos, ejecutar las siguientes lineas de comando en una terminal:<br>
  sudo -u postgres psql <br>
  CREATE DATABASE prueba; <br>
  CREATE USER postgres WITH PASSWORD 'postgres'; <br>
  ALTER ROLE postgres SET client_encoding TO 'utf8'; <br>
  ALTER ROLE postgres SET default_transaction_isolation TO 'read committed'; <br>
  ALTER ROLE postgres SET timezone TO 'UTC'; <br>

  GRANT ALL PRIVILEGES ON DATABASE prueba TO postgres; <br>
  \q <br>
  
  3.- Ejecutar el aplicativo.
  
  4.- Ingresar data, ejecute el siguiente comando en una terminal, (dirigirce a la carpeta raiz del proyecto es en donde esta el archivo insert_datos.sql)
  
  sudo -u postgres psql -d prueba -a -f insert_datos.sql
  
