# Этап сборки
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app

# Копируем исходный код и собираем проект
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Этап запуска
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app

# Копируем собранный JAR-файл
COPY --from=build /app/target/*.jar app.jar

# Открываем порт и запускаем приложение
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]