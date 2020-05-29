# Parallel Testing with Zalenium + AKS + Azure Pipeline
![project Logo](/CypressProjectLogo.png)

**Prerequisite**
1. Azure AKS cluster
2.Java environment 
3. Maven 
4.Azure DevOps Account

**Note: Configure web-driver path and test email address.**
	

- Configure webdriver.
    - I used ChromeDriver but you can choose other webdriver eg. Mozilla GeckoDriver 
    - So first download ChromeDriver from [http://chromedriver.chromium.org/downloads](http://chromedriver.chromium.org/downloads).
    - Copy your downloaded **chromedriver.exe** file path.
    - Go to `E2EUserJourney\src\test\java\testcases\mytheresa\WebdriverSettings.java` file.
    - Paste the copied file path in `System.setProperty("webdriver.chrome.driver","Paste path here")`.
	
Project is ready to run. Execute following commands and enjoy the automatic web-driver test.
- Go to project path in terminal. For example: C:\Users\User-Name\eclipse-workspace\E2EUserJourney>
- Run `mvn clean`
- Run `mvn compile`
- Run `mvn test`

You can find the test result in `DemoBlaze-E2E-Tests\target\surefire-reports\index.html`.