Step 0:
Pre-requisites:
Install docker and docker-compose!

Step 1:
Run the following command to start kafka + zookeeper in docker containers:
docker-compose -f docker-compose.yml up -d

Step 2:
Run KafkaDemoApp (Spring Boot application).0

Step 3:
Check KafkaController class.
Send request example to kafka endpoint (copy it to your http request file):

###
POST http://localhost:8180/kafka
Content-Type: application/json

{
  "topic": "hotel-request-example",
  "message": "test message"
}