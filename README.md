# CONSTRUCCIÓN
App que permite gestionar las solicitudes de construcción de una determinada compañia

# OBJETIVO
La empresa “Constructores S.A.S” requiere desarrollar una aplicación capaz de gestionar sus solicitudes de construcción en el terreno designado para la ciudadela, donde las solicitudes de construcción solo serán montadas por el arquitecto.

# ENVIRONMENT 
	•	Eclipse IDE for Enterprise Java Developers, Versión 2020-01 (4.17.0).
	•	Open JDK versión 11.
	•	SQL y PL/SQL Oracle versión 11g.
	•	Spring Tools 4, Versión 4.11.0.


# PROCESO DE INSTALACIÓN:

1) Descargar el proyecto del repositorio GitHub	
	 El código se encuentra alojado en GitHub. Para descargarlo necesita un cliente git, que puede encontrarlo en https://git-scm.com/downloads
			
    	* Cree una carpeta en donde se incluirá el código fuente
		* Abra su consola y posicionese en la carpeta previamente creada
		* Ejecute el comando: git clone https://github.com/cesarlatorre2021/Construccion.git

2) En la carpeta "ScripsBD" descargar todos los Scripts y ejecutarlos en la BD en siguiente orden:

		* Script de la creación del nuevo usuario Oracle CREACION_USUARIO.sql (Con el usuario administrador).
		* Script de creación de tablas de nombre SCRIPT_TABLAS.sql. (Con el nuevo usuario).
		* Script de creación de procedimientos PR_ACT_ESTADO_INICIAL.sql, PR_GENERAR_INFORME.sql y PR_ACT_ESTADO_FINALIZADO.sql. (Con el nuevo usuario).
		* Script de creación de JOBS JOB_ACT_ESTADO_ORDENES.sql. (Con el nuevo usuario).
		
3) En la carpeta "Documentacion" descargar y leer el documento "DocumentaciónProyecto.pdf" que contiene toda la descripción funcional del proyecto. Ver el siguiente enlace para la documentación swagger:

		* http://localhost:9090/construccion/api/swagger-ui.html
		
