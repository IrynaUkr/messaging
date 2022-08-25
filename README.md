
### Iryna Podoprygora
### project with using messaging

#### This project has two services a publisher and a consumer.
When the publisher receives a message on port 8081,
it creates a request and sends it to the consumer on port 8082.

The first implementation of Message Sender is MessageSenderServiceHTTP. 
The second implementation will be with using message broker RabbitMQ.
We can use different implementations with changing active profile (http or rabbit) in application.yml

Run RabbitMQ in Docker container()

docker run -d -p 5672:5672 -p 15672:15672 --name my-rabbit rabbitmq:3-management

15672 port is a default port for Rabbit.
If you do not have this image locally docker find it at load from docker repository
To enable Rabbit, add the spring- boot-starter-amqp dependency.

RabbitMQ web Console:
http://localhost:15672



