#PASOS

* Bajar el proyecto

## JAVA
* Verificar la versión de java instalada en tu maquina corriendo el comando `java --version`
    * Si es menor a la verisón 1.8 bajar java 8

## GRADLE
Para mas velocidad instalar gradle igualmente gradle corre mas rapido mientras mas seguido se use por que guarda todo en cache. Pero projecto igualmente trae el gradle así que no es necesario instalarlo. 

Si tenes instalado gradle en tu maquina los comando se corren como `gradle` sino como `./gradlew`


## Eclipse
* Bajar el eclipse (cualquiera) que sea EE
* Dentro de la carpeta del projecto correr el comando `gradle eclipse` o `./gradlew eclipse`

* Abrir el eclipse y crear un nuevo wokspace apuntando cualquier vacía que NO sea la carpeta del proyecto
* Archivo > Importar > General > Projecto existente dentro del Workspace
* Buscar carpeta > Seleccionar la carpeta del proyecto > Importar

 
##Wildlfy
 * Bajar el wildfly 12 
 * En la carpeta del wildfly ejecutar el comando `bin/add-user.sh` o `bin/add-user.bat`
    * Segir todos los pasos para crear un usuario Administrador con los sigiuentes datos
    * a) Management User
    * Usuario: administrator
    * Password: Passw0rd!
    * Sin grups y todo yes
    
## Levantar Widlfy
Dentro de la carpeta del wildfly correr el comando `bin/standalone.sh` o `bin/standalone.bat`

## Deployar el proyecto


* Dentro de una terminal en la base del proyecto correr `gradle deploy` si tienen instalado gradle o sino remplazar por `./gradlew deploy` 


## Estructura del proyecto
__jboss_concection.properties__ configuración de acceso al wildfly
__src/main/resources/META-INF/persistence.xml__ Archivo de persistencia JPA/Hibrenate
__/src/main/webapp__ Base de la carpeta web



