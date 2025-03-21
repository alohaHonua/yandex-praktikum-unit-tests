package ru.yandex.praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParameterizationExample {
    private final String email;
    private final String password;
    private final boolean result;

    public ParameterizationExample(String email, String password, boolean result) {
        this.email = email;
        this.password = password;
        this.result = result;
    }

    // Тестовые данные
    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][] {
                { "myMail@yandex.ru", "12345", true},
                { "yourMail@yandex.ru", "54321", false},
        };
    }

    @Test
    public void loginTest() {
        // Запускаем браузер, переходим на сайт и заполняем форму авторизации
        WebDriver driver = new ChromeDriver();
        driver.get("https://...");
        driver.findElement(By.className("email")).sendKeys(email);
        driver.findElement(By.className("password")).sendKeys(password);
        driver.findElement(By.className("form")).click();

        // Если логин прошел успешно (result = true), элемент profile отображается на экране
        // В противном случае элемент не виден
        assertEquals(result, driver.findElement(By.className("profile")).isDisplayed());
    }
}