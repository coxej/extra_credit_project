# extra_credit_project

To build:
  docker build -t my-app .
  
To run:
  docker run -itP --rm --name my-run my-app

Dockerfile1:
  I tried to run all the commands from this page (https://docs.google.com/document/d/1Nkhlb61rjRY55MaLW44bSMm5-FBqQEPpb0K4DJOOUmM/edit) to install UniTime on linux. There was an error with starting the mysql server and setting it up.
  
  
Dockerfile2:
  I tried to pull mysql and tomcat images instead of installing them on ubuntu image, this ran into a fatal error with the JDBC connection. It would still say it started the server but I could not get the app to load in a browser.
  

Dockerfile3:
  I tried to alter what I did in Dockerfile2 and do some additional setup for the tomcat. It would also say it started the server but it would not actually work.
  
  
An additional idea I was trying was to end the Dockerfile before the command 'mysql -uroot -p ...' and inject the rest of the commands through a java program that would run upon docker start. This, however, yielded the same problem with failing to be able to connect to the local mysql server.



*** To install this program locally, one would simple navigate to http://help.unitime.org/Timetabling_Installation and select the operating system they will be installing it on.
