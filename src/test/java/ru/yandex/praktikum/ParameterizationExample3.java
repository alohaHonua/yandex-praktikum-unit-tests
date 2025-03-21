package ru.yandex.praktikum;

import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.junit.runners.Parameterized;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.chrome.ChromeOptions;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;


        import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

@RunWith(Parameterized.class)
public class ParameterizationExample3 {
    private final String cityName;
    private final boolean isVisible;

    public ParameterizationExample3(String cityName, boolean isVisible) {
        this.cityName = cityName;
        this.isVisible = isVisible;
    }

    @Parameterized.Parameters
    public static Object[][] getCities() {
        return new Object[][]{
                {"Москва", true},
                {  "Санкт-Петербург", true},
        };
    }

    @Test
    public void citiesTest() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
       // options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://qa-mesto.praktikum-services.ru/");
        // Выполни авторизацию. Укажи email и пароль своей учетной записи
        driver.findElement(By.id("email")).sendKeys("kalnina_45@yandex.ru");
        driver.findElement(By.id("password")).sendKeys("123456788");
        driver.findElement(By.className("auth-form__button")).click();
        new WebDriverWait(driver, 15)
               .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//h2[text()='Москва']")));


        System.out.println(driver.findElement(By.xpath(".//p[@class = 'profile__description']")).getText());

        // Найди карточку города по его названию

        List<WebElement> elements = driver.findElements(By.xpath(".//h2[contains(text(), '" + cityName + "')]"));
        System.out.println(elements.size());



        // Проверь, что нашёлся хотя бы один нужный элемент
        assertEquals(isVisible, elements.size() > 0);
        driver.quit();
    }
}