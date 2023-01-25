# Rewards-REST-API
This Rewards REST API is built using Spring Boot. It will get customer rewards based on customer Id. If the customer Id cannot be found in the dataset, it will throw an exception and show a message “Error: Invalid / Missing Customer Id.”

# Project Description
A retailer offers a rewards program to its customers awarding points based on each recorded purchase as follows:
 
For every dollar spent over $50 on the transaction, the customer receives one point.
In addition, for every dollar spent over $100, the customer receives another point.
Ex: for a $120 purchase, the customer receives
(120 - 50) x 1 + (120 - 100) x 1 = 90 points

Given a record of every transaction during a three-month period, calculate the reward points earned for each customer per month and total. 

# Dataset and Results
![alt text](https://github.com/SuperRedTrain/Rewards-REST-API/blob/main/DataSetAndResults.png)

# Using
There is some instructions on how to use this Rewards REST API locally.

# To Run this API Project Locally
In your terminal, type the command:   
    git clone https://github.com/SuperRedTrain/Rewards-REST-API.git    

Go to the folder Rewards-REST-API, type the command in your terminal to run this Rewards REST API:   
    mvn spring-boot: run   

# To Calculate the Rewards for Each Customer
Open your browser, type:  
    http://localhost:8080/customers/{customerId}      

Example:  http://localhost:8080/customers/1001    
Response: {"customerId":1001,"name":"Alex","lastMonthRewardPoints":40,"lastSecondMonthRewardPoints":144,"lastThirdMonthRewardPoints":300,"totalRewardPoints":484}   

If you type:  http://localhost:8080/   
It will show a message:  Error: This Page Can Not Be Found. Please Try http://localhost:8080/customers/{customerId}   

# To Run the Unit Tests
Go to the folder Rewards-REST-API, type the command in your terminal:   
    ./mvnw test   

# Monitor the API by using Spring Boot Actuator
Open your browser, type:   
    http://localhost:8080/manage/health   
    http://localhost:8080/manage/info   

# To Run the Dockerized API Locally
First, make sure you have Docker running locally. Then, go to the folder Rewards-REST-API, type these commands in your terminal:    
    mvn install    
    docker build -t rewards-docker .   
    docker run -dp 8080:8080 rewards-docker   
Now, if you take a quick look at your Docker Dashboard, you should see at least one container running that is using the rewards-docker image and on port 8080. Open your browser, you can get customer rewards based on customer Id:    
    http://localhost:8080/customers/{customerId}    





