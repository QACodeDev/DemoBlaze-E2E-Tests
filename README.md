# Parallel Testing with Zalenium + AKS + Azure Pipeline
![project Logo](/ProjectPic.png)

## Project Summary
This project used to execute selenium tests in parallel by using the zalenium(installed on AKS by helm chart) through azure pipeline.Parallel test execution save lots of time ,effort and cost which helps faster in execution.I am using a sample website - https://www.demoblaze.com/

### Zalenium
A flexible and scalable container-based Selenium Grid with video recording, live preview, basic auth & dashboard. Start a Selenium Grid in seconds, a grid that scales up and down dynamically with this solution based on docker-selenium to run your tests in Firefox and Chrome. 

#### Zalenium’ s main goal is: to allow anyone to have a disposable and flexible Selenium Grid infrastructure. 

![project Logo](/Architecture.png)

### Why to use Zalenium?
Issue with selenium grid setup:

- Have a stable grid to run UI tests with Selenium
- Maintain it over time (keep up with new browser, Selenium and driver’s versions)
- Provide capabilities to cover all browsers and platforms Zalenium was created to solve the widespread issue that a lot of people have  when you have some tests, and you want to start running them in parallel. You start by getting into Selenium Grid but encounter roadblocks pretty quickly when trying to scale
- Features
- Allow anyone to have a disposable and flexible Selenium Grid infrastructure
- Zalenium Dashboard
- Zalenium Live Preview
- Video Recording
- Integrated with Sauce Labs, BrowserStack, TestingBot, CrossBrowserTesting, LambdaTest
- Test status and steps directly in the video
- Basic auth grid protection when deploying Zalenium in the cloud (AWS, GCP, …)
- Mount volumes across containers when you need to specific files in your tests
- Customizing screen width and height, and time zone

### Installation

One can install zalenium in multiple ways

- Docker
- Docker Swarm
- Docker Compose
- Kubernetes (Minikube, helm chart,AKS)
- Openshift
- AWS , GCP , Azure etc

### Prerequisite

- Azure account and Azure AKS cluster
- Java environment
- Maven
- Azure DevOps Account
- Azure CLI
- Kubectl

### Steps:

#### 1. Create AKS Cluster on AKS 

You can create a AKS cluster by Azure portal or Azure CLI

  Login into azure by CLI
  
  `az login`	
  
  Activate the correct subscription. Azure uses the concept of subscriptions to manage spending. You can get a list of subscriptions
  your account has access to by running:
  
  `az account list --refresh --output table`

Pick the subscription you want to use for creating the cluster, and set that as your default. If you only have one subscription you can ignore this step.

`az account set --subscription <YOUR-CHOSEN-SUBSCRIPTION-NAME>`
		
Create a resource group. Azure uses the concept of resource groups to group related resources together. We need to create a resource group in a given data center location

`az group create \
--name=<RESOURCE-GROUP-NAME> \
--location=centralus \
--output table`

Create an ssh key to secure your cluster.

`ssh-keygen -f ssh-key-<CLUSTER-NAME>`

Create a Kubernetes cluster with an existing SSH public key with default settings.

`az aks create -g <RESOURCE-GROUP-NAME>  -n <CLUSTER_NAME> --ssh-key-value /path/to/publickey`

Get credentials from Azure for kubectl to work:

`az aks get-credentials \
--name <CLUSTER-NAME> \
--resource-group <RESOURCE-GROUP-NAME> \
--output table`

Check if your cluster is fully functional

`kubectl get node`
		
		 
#### 2.Install Zalenium on AKS by using helm chart

Create a namespace for zalenium

`kubectl create namespace <NAME_SPACE>`

Add repo to helm

`helm repo add zalenium-github https://raw.githubusercontent.com/zalando/zalenium/master/charts/zalenium`

Check helm repo

`helm search repo zalenium`

install zalenium

`helm install <RELEASE_NAME> --namespace <NAME_SPACE> zalenium-github/zalenium --set hub.serviceType="LoadBalancer"`

Fetch the external IP address for zalenium kubernetes service

`kubectl get service <RELEASE_NAME>-zalenium --namespace="<NAME_SPACE>"`
	
after successfully installing Zalenium we can access below: 
Zalenium Live Preview - http://Host_IP/grid/admin/live 
Zalenium Dashboard - http://Host_IP/dashboard/# 
Zalenium Grid Console - http://Host_IP/grid/console 
Zalenium Hub - http://Host_IP/wd/hub 
		
#### 3.Download or clone the repository

`git clone`

#### 4.Update the GRID_HOST variable with IP address/Host name of grid inside UserVariables.java file

#### 5.Update the testng.xml for parallel execution (How many tests you want to run/Which tests/Cross browswer) 

#### 6.Create a new pipeline in azure by azure-pipelines.yml file in the project 

#### 7.Run the pipeline

### Results/Reports

You can find the reports/results in artifacts and videos from zalenium dashboard
