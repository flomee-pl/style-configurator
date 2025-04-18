FROM maven:3-amazoncorretto-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM amazoncorretto:21
WORKDIR /app
COPY --from=build /app/target/StyleConfigurator.jar .
CMD ["java","-jar", "StyleConfigurator.jar"]