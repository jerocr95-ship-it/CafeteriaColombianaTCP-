# ☕ Cafetería Colombiana TCP

## Unidad 2 – Concurrencia y Network

**Asignatura:** Programación en Java
**Proyecto:** Sistema de pedidos de cafetería mediante sockets TCP
**Integrante:** Jerónimo Castaño Restrepo
**Lenguaje de programación:** Java

## 1. Descripción del proyecto

Este proyecto consiste en una aplicación desarrollada en Java que simula un sistema de pedidos para una cafetería colombiana.

La aplicación utiliza una arquitectura cliente-servidor mediante sockets TCP, permitiendo que varios clientes se conecten a un servidor y realicen pedidos de café.

El servidor recibe las solicitudes y envía una confirmación a cada cliente.

## 2. Objetivo

Implementar los conceptos de comunicación en red, sockets TCP y concurrencia mediante una aplicación que permita atender varios clientes simultáneamente.

## 3. Arquitectura cliente-servidor

La aplicación está compuesta por dos programas principales:

**ServidorCafeteria.java**

Es el encargado de iniciar el servidor, escuchar las conexiones en el puerto 5000, recibir pedidos y enviar respuestas.

**ClienteCafeteria.java**

Permite conectarse al servidor, visualizar el menú de productos, enviar pedidos y recibir confirmaciones.

## 4. Implementación de concurrencia

El servidor utiliza hilos de Java para atender diferentes clientes.

Cuando un cliente establece una conexión, el servidor crea un hilo independiente utilizando la clase `Thread`.

De esta manera, puede continuar aceptando nuevas conexiones mientras atiende a los clientes conectados.

Los métodos principales utilizados son:

* `start()`: inicia la ejecución de un hilo.
* `currentThread()`: obtiene una referencia al hilo que está ejecutando una tarea.
* `getName()`: permite identificar el nombre del hilo.

## 5. Comunicación TCP

La comunicación se establece utilizando:

* `ServerSocket`: permite al servidor escuchar conexiones.
* `Socket`: establece la comunicación entre cliente y servidor.
* `BufferedReader`: permite recibir mensajes.
* `PrintWriter`: permite enviar respuestas.

**Host:** localhost (127.0.0.1)
**Puerto:** 5000
**Protocolo:** TCP

El servidor inicia la escucha y los clientes establecen las conexiones.

La comunicación finaliza cuando el cliente escribe `salir` o cuando se interrumpe la conexión.

## 6. Productos disponibles

La cafetería ofrece los siguientes productos:

* Café americano.
* Capuchino.
* Espresso.

## 7. Instrucciones para ejecutar el proyecto

Es necesario tener instalado el JDK de Java.

Primero, descargar o clonar el repositorio y abrir la carpeta del proyecto en una terminal.

### Compilar los archivos

```bash
javac ServidorCafeteria.java ClienteCafeteria.java
```

### Ejecutar el servidor

```bash
java ServidorCafeteria
```

El servidor comenzará a escuchar conexiones en el puerto 5000.

### Ejecutar el primer cliente

Abrir una segunda terminal y escribir:

```bash
java ClienteCafeteria
```

### Ejecutar el segundo cliente

Abrir una tercera terminal y escribir:

```bash
java ClienteCafeteria
```

Ambos clientes deben permanecer conectados simultáneamente para demostrar la concurrencia.

## 8. Ejemplo de funcionamiento

**Cliente 1**

Pedido enviado: Americano

Respuesta del servidor:

`Pedido confirmado: Americano`

**Cliente 2**

Pedido enviado: Capuchino

Respuesta del servidor:

`Pedido confirmado: Capuchino`

El servidor recibe y procesa los pedidos utilizando hilos independientes.

## 9. Uso de inteligencia artificial

Para el desarrollo de este proyecto se utilizó ChatGPT como herramienta de apoyo para comprender la arquitectura cliente-servidor, los sockets TCP y la implementación de concurrencia en Java.

También se utilizó como apoyo para estructurar el código y elaborar la documentación.

El código fue ejecutado y se verificó el funcionamiento de la conexión entre el servidor y los clientes.

**Correcciones o modificaciones realizadas durante las pruebas:** [Completar con los cambios realizados, si los hubo].

La herramienta de inteligencia artificial se utilizó como apoyo al aprendizaje y no como sustituto de la comprensión del funcionamiento del programa.

## 10. Conclusión

Este proyecto permitió aplicar los conocimientos adquiridos sobre comunicación en red y concurrencia en Java.

Mediante sockets TCP se logró establecer una comunicación entre un servidor y varios clientes.

La utilización de hilos permitió atender conexiones concurrentemente, demostrando la importancia de este mecanismo en aplicaciones cliente-servidor.

