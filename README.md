## Notifications Library

Librería Java (sin frameworks) para enviar notificaciones a múltiples canales (Email, SMS, Push) de forma extensible y desacoplada.

---

## Objetivo

Proveer una API simple y extensible para enviar notificaciones sin acoplarse a un proveedor o canal específico, permitiendo agregar nuevos canales sin modificar código existente.

---

## Requisitos
Java 21,
Maven

---

## Build & Run
1) Compilar
mvn clean package

Genera un fat-jar (incluye dependencias) en:

target/notifications-1.0.0.jar

2) Ejecutar
java -jar target/notifications-1.0.0.jar

Salida esperada:

Sending EMAIL via SendGrid to test@email.com with subject 'Hello'
Success: true
Message: Email sent successfully

## Testing

Se incluyen tests unitarios que cubren:

* Casos exitosos
* Validaciones
* Manejo de errores

Ejecutar:

mvn test
