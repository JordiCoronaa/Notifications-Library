## Notifications Library

Librería Java (sin frameworks) para enviar notificaciones a múltiples canales como Email, SMS y Push, de forma extensible y desacoplada.

##Instalación
Maven
<dependency>
    <groupId>com.novacomp</groupId>
    <artifactId>notifications</artifactId>
    <version>1.0.0</version>
</dependency>

## Build & Run 
1) Compilar
   mvn clean package
   Genera un fat-jar (incluye dependencias) en: target/notifications-1.0.0.jar
2) Ejecutar java -jar target/notifications-1.0.0.jar
   Salida esperada: Sending EMAIL via SendGrid to test@email.com with subject 'Hello' Success: true Message: Email sent successfully

## Quick Start
NotificationSenderFactory factory = new NotificationSenderFactory();

// Registrar canal Email
factory.register("email", new EmailNotificationSender(
        new EmailConfig("API_KEY", "SendGrid")
));

// Obtener sender
NotificationSender<EmailRequest> sender = factory.getSender("email");

// Crear request
EmailRequest request = new EmailRequest(
        "test@email.com",
        "Hello",
        "This is a test"
);

// Enviar
NotificationResponse response = sender.send(request);

System.out.println(response.getMessage());

## Configuración

Cada canal se configura mediante su clase Config correspondiente.

Email
EmailConfig config = new EmailConfig("API_KEY", "SendGrid");
SMS
SmsConfig config = new SmsConfig("API_KEY", "Twilio");
Push
PushConfig config = new PushConfig("API_KEY", "Firebase");

## Proveedores soportados

Actualmente la librería incluye integración simulada con:

Email → SendGrid (simulado)
SMS → Twilio (simulado)
Push → Firebase (simulado)

Nota: Las implementaciones actuales son simulaciones (logs). Se pueden extender para integraciones reales.


## API Reference

NotificationSender<T>

Interfaz principal para el envío de notificaciones.

NotificationResponse send(T request);
NotificationSenderFactory

Registro y obtención de canales dinámicos.

void register(String channel, NotificationSender<T> sender);

NotificationSender<T> getSender(String channel);
NotificationRequest

Interfaz base para los requests.

NotificationResponse

Objeto de respuesta del envío.

boolean isSuccess();
String getMessage();
String getErrorCode();

## Seguridad
  - No almacenar credenciales en el código fuente
  - Usar variables de entorno o vaults
  - En producción, evitar exponer API Keys en logs
  - Esta librería simula envíos, no realiza conexiones reales

## Testing

Ejecutar pruebas unitarias:
mvn test

Incluye:
Casos exitosos
Validaciones
Manejo de errores
