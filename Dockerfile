FROM tomcat

RUN rm -rf /usr/local/tomcat/webapps/*

ADD ./target/JXC-0.0.1-SNAPSHOT.war  /usr/local/tomcat/webapps/ROOT.war

ENV LANG C.UTF-8

EXPOSE 8080

CMD ["/usr/local/tomcat/bin/catalina.sh","run"]
