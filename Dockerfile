FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

# Copiar proyecto
COPY . .

# Dar permisos al wrapper
RUN chmod +x mvnw

# Compilar
RUN ./mvnw clean package -DskipTests

# Ejecutar ejemplo
CMD ["java", "-cp", "target/notifications", "com.novacomp.notifications.examples.NotificationExample"]