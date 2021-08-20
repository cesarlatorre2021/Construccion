CREATE OR REPLACE PROCEDURE PR_GENERAR_INFORME(
  P_ESTADO  OUT VARCHAR2
 ,P_MENSAJE OUT VARCHAR2
 ,P_RUTA    OUT VARCHAR2 
)IS
  v_archivo utl_file.file_type;
  V_CONT_PENDIENTES NUMBER;
  V_CONT_PROCESO    NUMBER;
  V_CONT_FINALIZADO NUMBER;
BEGIN
  
  BEGIN
    SELECT SC.DIRECTORY_PATH
      INTO P_RUTA
      FROM ALL_DIRECTORIES SC
     WHERE SC.DIRECTORY_NAME = 'DIR_READ';
  EXCEPTION WHEN NO_DATA_FOUND THEN
    P_RUTA := null;
  END;

  BEGIN
    SELECT COUNT(*)
      INTO V_CONT_PENDIENTES
      FROM SOLICITUDES SC
     WHERE SC.ESTADO = 'PENDIENTE';
  EXCEPTION WHEN NO_DATA_FOUND THEN
    V_CONT_PENDIENTES := 0;
  END;

  BEGIN
    SELECT COUNT(*)
      INTO V_CONT_PROCESO
      FROM SOLICITUDES SC
     WHERE SC.ESTADO = 'PROCESO';
  EXCEPTION WHEN NO_DATA_FOUND THEN
    V_CONT_PROCESO := 0;
  END;

  BEGIN
    SELECT COUNT(*)
      INTO V_CONT_FINALIZADO
      FROM SOLICITUDES SC
     WHERE SC.ESTADO = 'FINALIZADO';
  EXCEPTION WHEN NO_DATA_FOUND THEN
    V_CONT_FINALIZADO := 0;
  END;

  v_archivo := utl_file.fopen ('DIR_READ', 'Informe_Estados.txt', 'w');
  
  utl_file.put_line (v_archivo , 'Fecha de generación: '|| sysdate);
  utl_file.put_line (v_archivo , '');
  
  utl_file.put_line (v_archivo, '==================================================');
  utl_file.put_line (v_archivo, '     INFORME DE ESTADOS DE LAS CONSTRUCCIONES     ');
  utl_file.put_line (v_archivo, '==================================================');

  utl_file.put (v_archivo, RPAD('PENDIENTE',20));
  utl_file.put (v_archivo, RPAD('EN PROCESO',20));
  utl_file.put_line (v_archivo, RPAD('FINALIZADO',20));

  utl_file.put_line (v_archivo, '--------------------------------------------------');
  utl_file.put (v_archivo, RPAD(V_CONT_PENDIENTES,20));
  utl_file.put (v_archivo, RPAD(V_CONT_PROCESO,20));
  utl_file.put_line (v_archivo, RPAD(V_CONT_FINALIZADO,20));

  utl_file.fclose(v_archivo);
  
  P_ESTADO := 'OK';
  P_MENSAJE := 'Se generó el informe';
  
EXCEPTION 
  WHEN OTHERS THEN
    P_ESTADO := 'ER';
    P_MENSAJE := 'No se generó el informe';
    P_RUTA := null;
END;
/
