# SpringBoot 


## Installation instuctions

Build		: ./gradlew build  or ./gradlew build -x test (this is without tests) 
Run			: ./gradlew bootRun   
Index Url	: localhost:8080/{{server.servlet.context-path}}
If we want the project to be a war file add
	apply plugin: 'war' to the gradle build rename static folder(that contains index.html) to webapp and move it to src\main 

After the first installation please update 
spring.jpa.hibernate.ddl-auto=create to spring.jpa.hibernate.ddl-auto=update so that the table will not be deleted and created when running the app

## Database

Properties of the connection will be found in resources/application.properties.


### Endpoints Sum
	{[/taboogame/taboo],methods=[GET]}
	{[/taboogame/taboo],methods=[POST]}