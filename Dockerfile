FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copiar solo lo necesario primero (cache de dependencias)
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline

# Ahora sí, copiar el resto
COPY src src

RUN ./mvnw clean package -DskipTests

EXPOSE 8080

CMD ["java", "-jar", "target/*.jar"]