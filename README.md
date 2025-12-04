
<p align="center"> <strong>Desafío Conversor de Monedas</strong>
<br> Proyecto Java con consumo de API, JSON, pruebas y arquitectura limpia. </p>

<h1 align="center">Hola , mi nombre es Carlos <img src="https://media.giphy.com/media/hvRJCLFzcasrR4ia7z/giphy.gif" width="35"></h1>
<picture> <img align="right" src="https://github.com/7oSkaaa/7oSkaaa/blob/main/Images/Right_Side.gif?raw=true" width = 250px></picture>

## :triangular_ruler:
🛠 Funcionalidades del proyecto

✔ Conversión entre dos tipos de moneda

✔ Evita entrada de datos inválidos

✔ Resultado formateado con separador de miles

✔ Manejo de excepciones personalizado

✔ Inyección de dependencias (DI)

✔ Arquitectura por capas y paquetes

✔ Implementaciones reales y fake para pruebas

## :pencil2:
📌 Operación del programa

Usuario ingresa un número entre 1 y 6:	Selecciona tipo de conversión

Ingreso del código 0:	Ejecuta pruebas automáticas

Ingreso del número 7:	Finaliza la aplicación



🚀 Tecnologías usadas :rocket:

Java 17:	Lógica principal del sistema

ExchangeRate API	Obtención de tasas reales

Google Gson	Procesamiento de JSON

SOLID / Arquitectura Limpia	Diseño desacoplado, extensible y testeable


## :key:
🧠 Principios aplicados


SRP — Single Responsibility Principle

Cada clase tiene una única responsabilidad.

OCP — Open/Closed Principle


El Conversor permite nuevas fuentes de tasas sin ser modificado.

Abierto a extensión | Cerrado a modificación


DIP — Dependency Inversion Principle

Módulos de alto nivel no dependen de módulos de bajo nivel.

Ambos deben depender de abstracciones (interfaces).

usando:

IoC — Inversión de Control

El Conversor no crea el buscador, lo recibe externamente.

DI — Dependency Injection

La dependencia se suministra mediante el constructor del Conversor.


## :clapper:
📌 Esto permite:

Desacoplamiento:	Módulos independientes y mantenibles

Extensión sin romper código	Se pueden agregar nuevas fuentes de tasas

Testabilidad:	BuscadorDeTasasFake permite pruebas sin API


## :pushpin:
🏆 Buenas prácticas aplicadas


Constructor injection para dependencia obligatoria

BuscadorDeTasas como interfaz (OCP)

Conversor no instancia servicios, solo los recibe (DI/IoC)

Manejo de errores encapsulado

Clases pequeñas con responsabilidad única (SRP) para aplicar OCP

La clase Principal crea las dependencias (IoC)


## :key:
Estructura de paquetes:

src/

---->>> com/aluracursos/monedas/

-------->>> app/

------------>>> Principal.java

-------->>> excepcion/

------------>>> ErrorEnConversorException.java

-------->>> logica/

------------>>> Conversor.java

-------->>> servicio/

------------>>> BuscadorDeTasas.java (interfaz)

------------>>> BuscadorDeTasasDelJson.java (implementación real)

------------>>> BuscadorDeTasasFake.java (implementación fake)

## :flashlight:
- Acceso al proyecto: a través de GitHub
- Estado del proyecto: funcional 100%
- Características de la aplicación: Desafio conversor de monedas Alura Latam
- Desarrolladores: Carlos Arturo Torres Jara
👉 Licencia: código abierto
👉 Github: cartj2000
👉 Linkedin: CARLOS ARTURO TORRES JARA 


Agradecimientos:

- Alura Latam: Equipo docente
- Oracle: programa One Oracle Next Education
- ExchangeRate-API: API de conversión de monedas
