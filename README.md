Spring Boot Maven based App for building a Rest API for CRUD operations on Advertiser

Modules Used within the App are:
1) web
2) Actuators
3) MyBatis
4) Jacoco
5) Maven
6) Swagger 2
7) Docker

There are Six Endpoint in the API,

1) Create Advertiser  -- http://localhost:8080/adv-app/api/advertiser -- Post call 
   Input is Advertiser Model 
    Ex: 
    
    {
	"name":"Cocacola",
	"companyName":"Coca-cola",
	"creditScore": 789
	}
	
2) Get Advertiser based on Name 	http://localhost:8080/adv-app/api/advertiser/{name} returns Advertiser Model

3) Get All Advertiser ttp://localhost:8080/adv-app/api/advertiser returns list of Advertisers

4) Update  Advertiser based on Name http://localhost:8080/adv-app/api/advertiser/{name}.  -- PUT
		Input can be both companyName and creditScore  or either of the one based on User 
		
		{
				"companyName":"Coca-cola",
				"creditScore": 789
		}

5) Delete user based on Name http://localhost:8080/adv-app/api/advertiser/{name}

6) Get all for transaction return true if the user creditLimit is above supplied Credit Limit.
	http://localhost:8080/adv-app/api/advertiser/checkAdvertiserCreditStatus/{name}?creditScore=xxx
	By Default in the app I have set CreditLimit to 500 if the user doesnt provide in queryParam.
	
Steps to Run this App:

1)git clone Repo
2) If using IDE import as Maven Application. Run the Maven Build mvn clean install. Build the war and generate jacoco templates
3) Run as the Spring boot App.
	