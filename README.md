# Demo project for Async Spring Events with Kotlin

This is a sample project to test Spring Events with a simple API for publishing and retrieving message-based events.

### Build & Running
Gradle build
```
./gradlew clean build
```

To init the Spring boot app in http://localhost:8080
```
./gradlew bootRun
```

### Usage & Demo
Let's publish 3 messages
```
curl --location --request POST 'http://localhost:8080/simple-message-event' --header 'Content-Type: application/json' --data-raw '{"message": "Hello World! 1"}'
```
```
curl --location --request POST 'http://localhost:8080/simple-message-event' --header 'Content-Type: application/json' --data-raw '{"message": "Hello World! 2"}'
```
```
curl --location --request POST 'http://localhost:8080/simple-message-event' --header 'Content-Type: application/json' --data-raw '{"message": "Hello World! 3"}'
```
Events should be handled by the appropiate lister and stored. You can query the event log with:
```
curl --location --request GET 'http://localhost:8080/simple-message-event'
```
```json
[
  {
    "message": "Hello World! 1",
    "source": "Hello World! 1",
    "timestamp": 1612353581573
  },
  {
    "message": "Hello World! 2",
    "source": "Hello World! 2",
    "timestamp": 1612353627710
  },
  {
    "message": "Hello World! 3",
    "source": "Hello World! 3",
    "timestamp": 1612353630335
  }
]
```

By checking the app logs, we should notice the publishing and listening process. The listening process should be done in a separate thread from the provided TaskExecutor
```
INFO 86466 --- [TaskExecutor-17] c.m.k.d.l.SimpleMessageEventListener     : process=events_listener, status=listened, event=SimpleMessageEvent(message=Hello World! 1)
INFO 86466 --- [nio-8080-exec-1] c.m.k.domain.publisher.EventsPublisher   : process=events_publisher, status=published, event=SimpleMessageEvent(message=Hello World! 1)
INFO 86466 --- [nio-8080-exec-2] c.m.k.domain.publisher.EventsPublisher   : process=events_publisher, status=published, event=SimpleMessageEvent(message=Hello World! 2)
INFO 86466 --- [TaskExecutor-20] c.m.k.d.l.SimpleMessageEventListener     : process=events_listener, status=listened, event=SimpleMessageEvent(message=Hello World! 2)
INFO 86466 --- [TaskExecutor-23] c.m.k.d.l.SimpleMessageEventListener     : process=events_listener, status=listened, event=SimpleMessageEvent(message=Hello World! 3)
INFO 86466 --- [nio-8080-exec-3] c.m.k.domain.publisher.EventsPublisher   : process=events_publisher, status=published, event=SimpleMessageEvent(message=Hello World! 3)
```
