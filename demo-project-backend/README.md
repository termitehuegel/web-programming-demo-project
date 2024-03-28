# Demo Project Backend

This part of the project represents the backend of the demo project.
This is a spring boot web application written in kotlin.

## Prerequisites

Inorder for the build process to work it is necessary for the user to have `maven` installed.
Binaries for maven can be found under https://maven.apache.org/download.cgi.
Please make sure that you have set a system variable to the maven path and maven is installed correctly
by executing `mvn -v`.

Inorder to run the project it is recommended to install `docker` (and `docker-compose`).
Under windows please install `docker desktop` (https://www.docker.com/products/docker-desktop/).

## Build

Inorder to build this part of the project run `mvn clean install` in this directory. 
The output can be found under the `/target/` directory.

## Running

This project is intended to be executed with the help of docker using the provided `Dockerfile` or the
provided `docker-compose.yaml` (parent directory).

But you can execute this project without docker as well (not recommended) by starting the `start.bat`
in the `/target/demo-project-backend-<Version>-bin/` directory.
If you aren't using windows than use an equivalent command to the one used in the `start.bat` for your system.
It is expected that a sufficiently new version of `java` is installed and registered as a system variable.
