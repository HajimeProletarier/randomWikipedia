FROM tomcat:10
COPY target/randomwikipedia.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080
