FROM quay.io/wildfly/wildfly:latest

# Environment variables
ENV WILDFLY_HOME /opt/jboss/wildfly
ENV DEPLOYMENT_DIR $WILDFLY_HOME/standalone/deployments

# Admin for management console
RUN $WILDFLY_HOME/bin/add-user.sh admin admin --silent

# Копируем модуль Postgres
# COPY wildfly/modules $WILDFLY_HOME/modules

# Копируем CLI-скрипт
# COPY wildfly/setup.cli /opt/jboss/wildfly/setup.cli

# Выполняем CLI (создаёт datasource!)
# RUN $WILDFLY_HOME/bin/jboss-cli.sh --file=/opt/jboss/wildfly/setup.cli || true

# WAR file
COPY build/libs/city-service-0.0.1-SNAPSHOT.war $DEPLOYMENT_DIR/

# Create marker file for auto-deployment
RUN touch $DEPLOYMENT_DIR/city-service.war.dodeploy

EXPOSE 8080 9990 8787

# Start WildFly
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]