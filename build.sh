export project_name=advertiser-spring-boot-app

mvn clean package

#create the docker image for the app. This uses the Dockerfile
docker build -f Dockerfile -t $project_name:latest .

