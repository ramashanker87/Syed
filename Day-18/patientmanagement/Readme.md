# To run this Spring Application

## First run the docker compose file to create image of loaclstalk to use sqs service
docker-compose up

## patient-sqs-app is producer to send message 
### run the program - mvn spring-boot:run
### In postman - POST http://localhost:8081/send
data format -
    {
        "name":"Don",
        "id": 1,
        "hospitalName":"Hospital1",         
        "age":25,
        "gender":"M"
    }
###  before sending go to editor tab and add sessionid : sent

### Included spring security also so while sending use basic Auth 
#### username - patient
#### password - patient
Now send the data 

## doctor-sqs-app is a receiver 
### run the program - mvn spring-boot:run
### In postman - GET http://localhost:8082/receive
### Included spring security also so while receiving use basic Auth
#### username - doctor
#### password - doctor
### we will get the data and then deleted from the Amazon SQS


## To check Queue on loclastalk 
#### use link - https://app.localstack.cloud/inst/default/status
#### region we selected here - eu-west-1