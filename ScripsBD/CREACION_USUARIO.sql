alter session set "_ORACLE_SCRIPT"=true;
CREATE USER ACONSTRUCCION IDENTIFIED BY 1234567890;
GRANT ALL PRIVILEGES TO ACONSTRUCCION;
GRANT EXECUTE ANY PROCEDURE TO ACONSTRUCCION;
GRANT UNLIMITED TABLESPACE TO ACONSTRUCCION;