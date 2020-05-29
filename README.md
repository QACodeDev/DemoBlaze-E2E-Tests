# Parallel Testing with Zalenium + AKS + Azure Pipeline
![project Logo](/ProjectPic.png)
## Project Summary
This project is execute selenium tests in parallel by using the zalenium(installed on AKS by helm chart) through azure pipeline.Parallel test execution save lots of time ,effort and cost which helps faster execution.

### Zalenium
A flexible and scalable container-based Selenium Grid with video recording, live preview, basic auth & dashboard. Start a Selenium Grid in seconds, a grid that scales up and down dynamically with this solution based on docker-selenium to run your tests in Firefox and Chrome.
Zalenium’ s main goal is: to allow anyone to have a disposable and flexible Selenium Grid infrastructure.
![project Logo](/Architecture.png)
### Why to use Zalenium?
Issue with selenium grid setup:
- Have a stable grid to run UI tests with Selenium
- Maintain it over time (keep up with new browser, Selenium and driver’s versions)
- Provide capabilities to cover all browsers and platforms
Zalenium was created to solve the widespread issue that a lot of people have when you have some tests, and you want to start running them in parallel. You start by getting into Selenium Grid but encounter roadblocks pretty quickly when trying to scale

### Features
- Allow anyone to have a disposable and flexible Selenium Grid infrastructure
- Zalenium Dashboard
- Zalenium Live Preview
- Video Recording
- Integrated with Sauce Labs, BrowserStack, TestingBot, CrossBrowserTesting, LambdaTest
- Test status and steps directly in the video
- Basic auth grid protection when deploying Zalenium in the cloud (AWS, GCP, …)
- Mount volumes across containers when you need to specific files in your tests
- Customizing screen width and height, and time zone

### Zalenium Integrations
- Docker
- Docker Swarm
- Docker Compose
- Kubernetes (Minikube, helm chart,AKS)
- Openshift
- AWS , GCP , Azure etc

## Prerequisite
1. Azure account and Azure AKS cluster
2. Java environment 
3. Maven 
4. Azure DevOps Account

## Steps:
1. Create AKS Cluster on AKS
2.Install Zalenium on AKS by using helm,after successfully installing Zalenium we can access below:
 Zalenium Live Preview - http://Host_IP/grid/admin/live
 Zalenium Dashboard - http://Host_IP/dashboard/#
 Zalenium Grid Console - http://Host_IP/grid/console
 Zalenium Hub - http://Host_IP/wd/hub
3.Download or clone the repository 
4. Update the GRID_HOST variable with IP address/Host name of grid inside UserVariables.java file
5. Update the testng.xml for parallel execution (How many tests you want to run/Which tests/Cross browswer)
6.Create a new pipeline in azure by azure-pipelines.yml file in the project
7.Run the pipeline

### Results
You can find the reports/results in artifacts and videos from zalenium dashboard


	

