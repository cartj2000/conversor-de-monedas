🪙 Conversor de Monedas — Challenge
<p align="center"> <strong>Desafío Conversor de Monedas</strong><br> Proyecto Java con consumo de API, JSON, pruebas y arquitectura limpia. </p>
🛠 Funcionalidades del proyecto

✔ Conversión entre dos tipos de moneda

✔ Evita entrada de datos inválidos

✔ Resultado formateado con separador de miles

✔ Manejo de excepciones personalizado

✔ Inyección de dependencias (DI)

✔ Arquitectura por capas y paquetes

✔ Implementaciones reales y fake para pruebas

📌 Operación del programa
Acción	Función
Usuario ingresa un número entre 1 y 6	Selecciona tipo de conversión
Ingreso del código 0	Ejecuta pruebas automáticas
Ingreso del número 7	Finaliza la aplicación
🚀 Tecnologías usadas
Tecnología	Uso
Java 17	Lógica principal del sistema
ExchangeRate API	Obtención de tasas reales
Google Gson	Procesamiento de JSON
SOLID / Arquitectura Limpia	Diseño desacoplado, extensible y testeable
🧠 Principios aplicados

SRP — Single Responsibility Principle
Cada clase tiene una única responsabilidad.

OCP — Open/Closed Principle
El Conversor permite nuevas fuentes de tasas sin ser modificado.
👉 Abierto a extensión | Cerrado a modificación

DIP — Dependency Inversion Principle
Módulos de alto nivel no dependen de módulos de bajo nivel. 
Ambos deben depender de abstracciones (interfaces).
usando:
IoC — Inversión de Control
El Conversor no crea el buscador, lo recibe externamente.
DI — Dependency Injection
La dependencia se suministra mediante el constructor del Conversor.

📌 Esto permite:

Desacoplamiento	Módulos independientes y mantenibles
Extensión sin romper código	Se pueden agregar nuevas fuentes de tasas
Testabilidad	BuscadorDeTasasFake permite pruebas sin API

🏆 Buenas prácticas aplicadas

Constructor injection para dependencia obligatoria

BuscadorDeTasas como interfaz (OCP)

Conversor no instancia servicios, solo los recibe (DI/IoC)

Manejo de errores encapsulado

Clases pequeñas con responsabilidad única (SRP) para aplicar OCP

La clase Principal crea las dependencias (IoC)



