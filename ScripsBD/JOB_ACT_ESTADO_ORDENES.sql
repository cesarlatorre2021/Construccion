BEGIN
  SYS.DBMS_SCHEDULER.CREATE_JOB(
    job_name        => 'JOB_ACT_ORDENES_INICIAL'
   ,job_type        => 'STORED_PROCEDURE'
   ,start_date      => TO_TIMESTAMP_TZ('19/08/2021 08:00:00.000 AM -05:00','dd/MM/yyyy hh12:mi:ss.ff AM tzr')
   ,repeat_interval => 'FREQ=DAILY'
   ,auto_drop       => TRUE
   ,job_action      => 'PR_ACT_ESTADO_INICIAL'
   ,comments        => 'Job que permite actualizar el estado PENDIENTE a PROGRESO de las ordenes de construccion.'
  );
  DBMS_SCHEDULER.ENABLE
  (
    name    =>  'JOB_ACT_ORDENES_INICIAL'
  );
END;
/

BEGIN
  SYS.DBMS_SCHEDULER.CREATE_JOB(
    job_name        => 'JOB_ACT_ORDENES_FINALIZADO'
   ,job_type        => 'STORED_PROCEDURE'
   ,start_date      => TO_TIMESTAMP_TZ('19/08/2021 08:00:00.000 PM -05:00','dd/MM/yyyy hh12:mi:ss.ff AM tzr')
   ,repeat_interval => 'FREQ=DAILY'
   ,auto_drop       => TRUE
   ,job_action      => 'PR_ACT_ESTADO_FINALIZADO'
   ,comments        => 'Job que permite actualizar el estado PROGRESO a FINALIZADO de las ordenes de construccion'
  );
  DBMS_SCHEDULER.ENABLE
  (
    name    =>  'JOB_ACT_ORDENES_FINALIZADO'
  );
END;
/