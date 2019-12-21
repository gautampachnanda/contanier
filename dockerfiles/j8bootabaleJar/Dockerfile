FROM openjdk:8
VOLUME /tmp
ENV JAR_FILE=target/*-SNAPSHOT.jar
ENV APP_NAME app
ENV JAR_NAME $APP_NAME.jar
ENV JAR_PATH /$JAR_NAME
RUN echo $JAR_FILE 
RUN echo $JAR_PATH
COPY ${JAR_FILE} /app/${JAR_NAME}
RUN mkdir /logs && mkdir /logs/app
COPY entrypoint.sh docker-entrypoint.sh
RUN ls -lah /app/${JAR_NAME}
RUN ls -lah /
RUN cat docker-entrypoint.sh
RUN chmod +rwx docker-entrypoint.sh
ENTRYPOINT [ "bash","docker-entrypoint.sh"]