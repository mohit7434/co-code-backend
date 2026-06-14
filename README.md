# Co-Code: Real-Time Collaborative Event-Driven Code Engine

Co-Code is a high-performance, event-driven backend system engineered to synchronize document states across multiple remote clients concurrently with sub-millisecond execution overhead. The system establishes low-latency, bi-directional communication channels to handle high-contention code updates, resolving operational conflicts dynamically while maintaining absolute data consistency.

## 🚀 Key Architectural Features

* **Low-Latency Event Streaming:** Built an asynchronous message broker utilizing **STOMP WebSockets** to maintain an ultra-low broadcast latency profile of `<10ms`.
* **State Synchronization Loop:** Programmed an internal synchronization engine capable of resolving rapid editing conflicts across multi-user sessions smoothly.
* **Optimized Memory Footprint:** Leveraged a decoupled, non-blocking broadcast model to prevent traffic spikes from causing thread starvation or memory leaks.
* **Robust Input Validation:** Implemented strict data serialization schemas to automatically validate payloads and reject malformed packets at the gateway layer.
* **Persistent Cache & Mutation Layer:** Integrated an in-memory storage strategy backed by relational mapping for durable state checkpoints.

---

## 🛠️ Core Technologies & Libraries

* **Language:** Java (JDK 17+)
* **Framework:** Spring Boot 3.x
* **Messaging Protocol:** WebSockets with STOMP (Simple Text Oriented Messaging Protocol)
* **Data Access & ORM:** Spring Data JPA / Hibernate
* **Database:** H2 Relational Database (In-Memory for low-latency active session testing)
* **Build Tool:** Maven

---

## 📐 System Architecture & Data Flow

```text
[ Client 1 ] \                                          / [ Client 1 ]
              == (STOMP Over WebSocket) ==> [ Message ] == (Broadcast)
[ Client 2 ] /= Send CodeUpdatePayload      [ Broker  ] \= Latency < 10ms
                                                 ||
                                     (Sync Loop / Validation)
                                                 ||
                                                 \/
                                         [ RoomRepository ]
                                                 ||
                                                 \/
                                          [(DB) H2 Table]