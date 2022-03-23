FROM maven:3.8.4-jdk-11
WORKDIR /todo
COPY . .
RUN mvn install -DskipTests
CMD mvn spring-boot:run -X