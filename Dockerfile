# Etapa 1: Construcción de la aplicación
FROM eclipse-temurin:17-jdk-jammy AS build
WORKDIR /app

# Copiar archivos de Maven Wrapper y pom.xml
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Descargar dependencias (aprovechando la caché de Docker)
RUN ./mvnw dependency:go-offline

# Copiar el código fuente
COPY src ./src

# Compilar el paquete jar ejecutable
RUN ./mvnw clean package -DskipTests

# Etapa 2: Imagen final de ejecución
FROM eclipse-temurin:17-jre-jammy
LABEL authors="antonio"
WORKDIR /app

# Copiar el jar generado desde la etapa de construcción
COPY --from=build /app/target/*.jar app.jar

# Exponer el puerto de Spring Boot
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]