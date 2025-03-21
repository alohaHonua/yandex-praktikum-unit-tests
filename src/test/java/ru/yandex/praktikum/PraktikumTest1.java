package ru.yandex.praktikum;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PraktikumTest1 {

    private WebDriver driver;

    @Test
    public void test() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-mesto.praktikum-services.ru/");
        // Найди поле "Email" и заполни его
        driver.findElement(By.xpath(".//input[@id='email']")).sendKeys("kalnina_45@yandex.ru");
        // Найди поле "Пароль" и заполни его
        driver.findElement(By.xpath(".//input[@id='password']")).sendKeys("123456788");

        //Явное ожидание
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//a[text()='Войти']"))));


        // Найди кнопку "Войти" и кликни по ней
        driver.findElement(By.xpath(".//button[@class='auth-form__button']")).click();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}