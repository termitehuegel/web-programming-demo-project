# Demo Project (Web Programming)

This is a demo project for a module at the HWR-Berlin.
The project is split into two parts, the backend and the frontend.
The goal of this project is the demonstrate the viability of a specific web framework for the development of
single-page web applications.
In this case angular has been chosen.
For further information about the projects please read the `README.md` in the corresponding subdirectory or
read the paper about the frontend of this project.

## Prerequisites

Inorder for you to be able to build both parts of this projects number of tools are required.
- Maven
- Node.js

Inorder for you to be able to run both parts of this project at least one of these tools is required.
- Docker Desktop (recommended)
- Java

For more information about this, please read the corresponding `README.md`.

## Build

To build the backend navigate to the `./demo-project-backend/` subdirectory and execute `mvn clean install`.
If you did everything right, then the `./demo-project-backend/target/` directory should have appeared.

To build the frontend of the project navigate to the `./demo-project-frontend/` subdirectory and execute `npm install`
and after it successfully finished execute `ng build`.
If you did everything right, then the `./demo-project-frontend/dist/` directory should have appeared.

For more detailed information about the build process, consult the `README.md` of the corresponding subproject.

## Running

Inorder to execute this project please build both parts of the project as described above and then execute 
`docker compose up --build` in this working directory. 
The docker compose starts both parts of this project as a service.
The frontend is available under http://localhost:80/ while the backend works starts under http://localhost:8080/.

For more information and other running configurations please consult the corresponding `README.md` of a subproject.