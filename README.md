<h1 align="center">Desafio Conversor De Monedas</h1>

<h2 align="center">
:white_check_mark:Desafio Conversor de Monedas:white_check_mark:</h2>
##:hammer:Funcionalidades del proyecto
-Realizar la conversión entre dos tipos de moneda
-Evitar la entrada de datos incorrecta
-Mostar el resultado claro con separador de miles
-Manejo de excepciones personalizado
-Aplicación de inyección de dependencias
-Estructura de paquetes
-Organización por capas
-Código de prueba
##:hammer:
-El usuario digita un número entre 1 y 6 para seleccionar la conversión
-Si se digita el código 888 se realiza una prueba
-Al oprimir 7 el sistema termina
<h3 align="center">:rocket:Tecnologias usadas:
-Java 17: código
-ExchangeRate API: manejo de tasas 
-Google Gson: procesamiento del JSON
-SOLID: {
SRP: Single Responsibility Principle
OCP:Open Close Principle
DIP:Dependency Inversion Principle
módulos de alto nivel 
no deben depender
de módulos de bajo nivel
ambos deben depender 
de abstracciones (interfaces)
usando:
DI: suministrar esas abstracciones a una clase
IoC: organizar la creación (instancias)
}
-Open / Closed Principle (OCP):
para usar diferentes fuentes sin tocar el Conversor
El Conversor está abierto a extensión 
y se puede pasar otra implementación
El Conversor está cerrado a modificación 
y no hay que reescribirlo
-Inversión de Control (IoC):
El Conversor no crea el buscador, 
sino que es entregado desde afuera 
a través del contrato o interfaz
-Inyección directa (DI):
Se inyecta la dependencia desde fuera
para implementar la IoC
Todo para crear un sistema:
desacoplado (DI, IoC)
extensible sin modificar (OCP)
testeable (BuscadorDeTasasFake)
</h3>
<h4 align="center"> Buenas prácticas:
-constructor inyección para dependencia obligatoria
-uso de interfaz BuscadorDeTasas para cumplir OCP
-no se usa new en la clase de negocio
-encapsular en lo posible el manejo de errores
-clases pequeñas con responsabilidad única (SRP) para aplicar OCP
-la clase principal crea/compone las dependencias (IoC)
-Conversor no crea su dependencia, la recibe por constructor (DI)
-Se puede añadir otra implementación BuscadordeTasasFake u otra sin tocar Conversor (OCP)



