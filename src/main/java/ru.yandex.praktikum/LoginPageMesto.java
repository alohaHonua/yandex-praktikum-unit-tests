package ru.yandex.praktikum;

// импортировали классы By и WebDriver, которые будут использоваться в коде
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.AssertJUnit.assertEquals;

// Шаг 1. Создали page object — класс для страницы
public class LoginPageMesto {

    // Шаг 2. Добавили поле driver
    private WebDriver driver;

    // Шаг 3. Добавили локаторы .
    private By signInButton = By.className("auth-form__button");

    // локатор поля «Email»
    private By emailField = By.id("email");
    // локатор поля «Пароль»
    private By passwordField = By.id("password");

    // добавь здесь локатор для кнопки «Регистрация»
    private By registrationButton = By.xpath(".//a[@class = 'header__auth-link']");

    // Шаг 4. Добавили конструктор класса page object
    public LoginPageMesto(WebDriver driver){
        this.driver = driver; // Инициализировали в нём поле driver
    }

    // Шаг 5. Добавили метод, который кликает по кнопке «Войти»
    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

    // метод проверяет текст кнопки «Регистрация»
    public void checkTextRegistrationButton() {
        assertEquals("Регистрация", driver.findElement(registrationButton).getText(), "Текст неверный");
    }
    // метод заполняет поля «Email»
    public void setUsername(String username) {
        driver.findElement(emailField).sendKeys(username);
    }
    // метод заполненяет поля «Пароль»
    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    // метод кликает по кнопке авторизации
   // уже есть выше (Шаг 5)

    // метод авторизации в приложении: объединяет ввод email, пароля и клик по кнопке
    // это и есть шаг
    public void login(String username, String password){
        setUsername(username);
        setPassword(password);
        clickSignInButton();
    }

}
