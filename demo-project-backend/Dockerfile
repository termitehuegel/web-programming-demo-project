FROM openjdk:20
ENV E_VERSION=0.0.0
ENV E_APP_NAME=demo-project-backend
COPY target/${E_APP_NAME}-${E_VERSION}-bin/ /opt/${E_APP_NAME}/
WORKDIR /opt/${E_APP_NAME}/
ENTRYPOINT java -jar -Dspring.config.additional-location=${E_APP_NAME}-config.yml /opt/${E_APP_NAME}/lib/${E_APP_NAME}-${E_VERSION}.jar
