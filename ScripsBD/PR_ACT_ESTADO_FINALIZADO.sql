CREATE OR REPLACE PROCEDURE PR_ACT_ESTADO_FINALIZADO AS
  TYPE TYPE_SOLICITUDES IS TABLE OF SOLICITUDES%ROWTYPE INDEX BY BINARY_INTEGER;
  V_TYPE_SOLICITUDES TYPE_SOLICITUDES;
BEGIN
  SELECT *
    BULK COLLECT INTO V_TYPE_SOLICITUDES
    FROM SOLICITUDES SC
   WHERE SC.ESTADO = 'PROGRESO'
     AND TRUNC(SC.FECHA_FIN_CONSTRUCCION) = TRUNC(SYSDATE + 4);

  IF V_TYPE_SOLICITUDES IS NOT NULL AND V_TYPE_SOLICITUDES.COUNT > 0 THEN
    FOR I IN V_TYPE_SOLICITUDES.FIRST .. V_TYPE_SOLICITUDES.LAST LOOP
      UPDATE SOLICITUDES
         SET ESTADO = 'FINALIZADO'
            ,FECHA_MODIFICACION_REG = SYSDATE
       WHERE ID_SOLICITUD = V_TYPE_SOLICITUDES(I).ID_SOLICITUD;
    END LOOP;
  END IF;
END;
/