# 📡 Práctica Didáctica: Arquitectura Cliente-Servidor (TCP Sockets)

Este proyecto es una implementación básica de una arquitectura **Cliente-Servidor** en Java utilizando la clase `java.net.Socket`.

El objetivo de esta actividad es comprender cómo se establece una conexión local, cómo se produce el **flujo de datos síncrono** (entrada/salida) y cómo interactúan dos procesos independientes a través de un puerto de red.

---

## 📂 Estructura del Proyecto

El proyecto consta de dos archivos fuente principales:

- **`Server.java`**: Actúa como el receptor. Abre un puerto y espera pasivamente a que alguien se conecte.
- **`Client.java`**: Actúa como el emisor/iniciador. Busca al servidor y solicita establecer una conexión.

---

## 🛠️ Requisitos Previos

- **Java Development Kit (JDK)** instalado (versión 8 o superior).
- **Visual Studio Code** (o cualquier otro IDE/Terminal).
- Ambos archivos deben estar en la misma carpeta o paquete para esta prueba básica.

---

## 🚀 Guía de Ejecución (Paso a Paso)

Para que la comunicación funcione, el orden de ejecución es **crítico**.

### 1. Compilar el código

Abre tu terminal en la carpeta donde están los archivos y ejecuta:

```bash
javac Server.java Client.java
2. Iniciar el Servidor (¡IMPORTANTE: Hacer esto primero!)El servidor debe estar "escuchando" antes de que el cliente intente llamar.Bashjava Server
Salida esperada: Verás el mensaje Connecting to Client... y el cursor se quedará parpadeando. El servidor está bloqueado esperando una conexión (accept()).3. Iniciar el ClienteAbre una segunda terminal (o una nueva pestaña en VS Code) y ejecuta:Bashjava Client
Salida esperada: Verás Successfully Connected!.En la terminal del Servidor aparecerá también Successfully Connected!.4. Flujo de ComunicaciónEn la terminal del Cliente, el programa te pedirá: Please enter your name:.Escribe tu nombre (ej. "Carlos") y pulsa Enter.El Cliente envía el dato al Servidor.El Servidor recibe el nombre, lo muestra y responde con un saludo.El Cliente recibe el saludo y lo muestra: Server: Hello, Carlos.Ambos programas se cierran automáticamente.🧠 Conceptos Clave (Didáctica)En este código se ilustran los siguientes conceptos de redes:ConceptoExplicación en el códigoServerSocketEs como el "teléfono fijo" del servidor. Se queda esperando una llamada en un puerto específico (5000).SocketEs el "cable virtual" que se crea una vez que la llamada es aceptada. Permite enviar y recibir datos.Localhost (127.0.0.1)Dirección IP de bucle invertido. Significa "esta misma máquina". El cliente busca al servidor en su propio ordenador.Puerto 5000Es la puerta lógica por la que entran los datos. Ambos deben coincidir en este número.Bloqueo (Blocking I/O)Observa cómo serverSocket.accept() y reader.readLine() detienen la ejecución del programa hasta que ocurre algo externo. Esto es una comunicación síncrona.Streams (Flujos)getInputStream y getOutputStream son los canales unidireccionales por donde viajan los bytes de un lado a otro.⚠️ Posibles Errores ComunesConnection refused: Ocurre si ejecutas el Client sin haber encendido antes el Server. El cliente llama a una puerta donde nadie escucha.Address already in use: Ocurre si intentas arrancar el Server dos veces seguidas sin cerrar el anterior. El puerto 5000 sigue ocupado por la instancia anterior.
```
