# secondapp

An application which works with "company" application's beans.

To launch the application in docker you need to use the commands from the root directory:
1. mvn clean package
2. mv target/secondapp.war dockerfiles/glassfish/autodeploy/secondapp.war
3. docker-compose up

To clean docker after using the application you can use the command from the root directory:

./clean.sh