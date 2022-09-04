package com.fb.qa.myproperties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class LoginPageProp {
        public static void main(String[] args) throws IOException {
            WebDriver driver = null;
            //read properties file
            Properties prop = new Properties();
            FileInputStream fis = new FileInputStream("C:\\Users\\darsh\\IdeaProjects\\FacebookPagesAutomation\\src\\main\\java\\config.properties");
            prop.load(fis);
            System.out.println(prop.getProperty("browser"));
            String browserName = prop.getProperty("browser");

            if (browserName.equals("chrome")) {
                // WebDriverManager.chromedriver().setup();
                System.setProperty("webdriver.chrome.driver","C:/Users/darsh/Desktop/chromedriver_win32 (2)/chromedriver.exe");
                driver = new ChromeDriver();
            }
            //else if (browserName.equals("IE")) {
            //  WebDriverManager.internetexplorerdriver().setup();
            //   driver = new ChromeDriver();
            //   }
            else {
                System.out.println("No browser value given");
            }

            driver.get(prop.getProperty("url"));
            driver.findElement(By.name(prop.getProperty("username_name"))).sendKeys("email");
            driver.findElement(By.name(prop.getProperty("password_name"))).sendKeys("password");
            driver.findElement(By.xpath("loginBtn_xpath")).click();
        }
}

