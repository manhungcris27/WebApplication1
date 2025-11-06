FROM tomcat:10.1-jdk17

# Xóa ứng dụng mẫu mặc định
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy file WAR sau khi build
COPY ./dist/WebApplication1.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080

CMD ["catalina.sh", "run"]
