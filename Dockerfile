FROM tomcat:10
COPY randomwikipedia.war /usr/local/tomcat/webapps/ROOT.war
COPY entrypoint.sh /usr/local/tomcat/bin/entrypoint.sh
RUN chmod +x /usr/local/tomcat/bin/entrypoint.sh
EXPOSE 8080
ENTRYPOINT ["/usr/local/tomcat/bin/entrypoint.sh"]
