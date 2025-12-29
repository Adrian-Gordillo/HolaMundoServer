# Educational Practice: Client-Server Architecture (TCP Sockets)

This project is a basic implementation of a **Client-Server** architecture in Java using the `java.net.Socket` class.

The goal of this activity is to understand how a connection is established, how **data flow** (input/output) occurs, and how two independent processes interact through a network port.

---

## Project Structure

The project consists of two main source files:

- **`Server.java`**: Acts as the receiver. It opens a port and passively waits for someone to connect.
- **`Client.java`**: Acts as the sender/initiator. It looks for the server and requests to establish a connection.

---

## Execution Guide (Step-by-Step)

For communication to work, the order of execution is **critical**.

### 1. Compile the code

Open your terminal in the folder where the files are located and run:

### 2. Start the Server (IMPORTANT: Do this first!)

The server must be "listening" before the client tries to call.

Expected Output: You will see the message Connecting to Client... and the cursor will blink. The server is blocked waiting for a connection (accept()).

### 3. Start the Client

Open a second terminal (or a new tab in VS Code) and run:

Expected Output: You will see Successfully Connected!.

In the Server terminal, Successfully Connected! will also appear.

### 4. Communication Flow

In the Client terminal, the program will ask: Please enter your name:.

Type your name (e.g., "Adrián") and press Enter.

The Client sends the data to the Server.

The Server receives the name, displays it, and responds with a greeting.

The Client receives the greeting and displays it: Server: Hello, Adrián.

Both programs close automatically.

---

## Key Concepts (Didactic)

This code illustrates the following networking

- **`concepts`**: ConceptExplanation in code

- **`ServerSocket`**: It acts like the server's "landline phone". It stays waiting for a call on a specific port (5000).

- **`Socket`**: It is the "virtual cable" created once the call is accepted. It allows sending and receiving data.

- **`Localhost (127.0.0.1)`**: Loopback IP address. It means "this same machine". The client looks for the server on its own computer.

- **`Port 5000`**: It is the logical door through which data enters. Both must agree on this number.

- **`Blocking I/O`**: Notice how serverSocket.accept() and reader.readLine() stop the program execution until an external event occurs. This is synchronous communication.

- **`Streams`**: **getInputStream** and **getOutputStream** are the unidirectional channels through which bytes travel from one side to the other.
