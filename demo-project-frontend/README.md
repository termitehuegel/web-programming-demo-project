# Demo Project Frontend

This part of the project represents the frontend of the demo project.
It is written in angular and communicates with the backend via HTTP.

## Prerequisites

Inorder for the build process to work it is necessary for the user to have `node.js` installed.
Binaries for node.js can be found under https://nodejs.org/en.
Next you should install the Angular CLI via `npm install -g @angular/cli`.
After installing Angular execute `npm install` in this directory.
Subsequently, a `/node_modules/` directory should appear.

Inorder to run the project it is recommended to install `docker` (and `docker-compose`).
Under windows please install `docker desktop` (https://www.docker.com/products/docker-desktop/).

## Build

Inorder to build this part of the project run `ng build`.
The output can be found under the `/dist/demo-project-frontend/browser/` directory.

## Running

This project is intended to be executed with the help of docker using the provided `Dockerfile` or the
provided `docker-compose.yaml` (parent directory).

But you can execute this project without docker as well (not recommended) by starting your own webserver which
serves the `/dist/demo-project-frontend/browser/` directory.
Alternatively, you can start a development webserver under the port 4200 with `ng serve`.
