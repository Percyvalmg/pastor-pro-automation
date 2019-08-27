import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Autocomplete {

    private WebDriver driver;
    private WebDriverWait wait;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/Personal/Downloads/chromedriver");
        Autocomplete autocomplete = new Autocomplete();
        autocomplete.driver = new ChromeDriver();
        autocomplete.driver.get("http://somedomain/url_that_delays_loading");
        autocomplete.wait = new WebDriverWait(autocomplete.driver, 60);

        autocomplete.loginToPastorPro();
        autocomplete.goToEventsTab();
        autocomplete.clickPreviousWeekButton();
        autocomplete.selectViewAllRadioButton();
        autocomplete.clickCellMeeting();
        autocomplete.selectCellMember();
    }

    private void isLoading(WebDriverWait wait, int threadSleepTimeInSeconds) {
        boolean invisible = wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("\"//*[@id=\\\"ShowProgressLoderManual\\\"]\""), "Loading"));
        try {
            if (invisible)
                Thread.sleep(threadSleepTimeInSeconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void loginToPastorPro(){
        driver.get("https://www.pastorpro.com/Home/LoginPage");
        isLoading(wait,2);
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtuser")));
        username.sendKeys("percyvalg@gmail.com");
        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtpass")));
        password.sendKeys("19962511");
        password.sendKeys(Keys.ENTER);
    }

    private void goToEventsTab(){
        isLoading(wait,2);
        WebElement eventsTab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tabEventTab\"]/a")));
        isLoading(wait,2);
        eventsTab.click();
    }

    private void selectViewAllRadioButton(){
        isLoading(wait,2);
        WebElement allCellsRadioButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("redAllEvent")));
        isLoading(wait,2);
        allCellsRadioButton.click();
    }

    private void clickPreviousWeekButton(){
        isLoading(wait,2);
        WebElement previousWeekButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("linkPrevWeek")));
        isLoading(wait,2);
        previousWeekButton.click();
    }

    private void clickCellMeeting(){
        isLoading(wait,2);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"CellsGrid\"]/div[4]/table/tbody/tr[2]/td[2]/a")));
        isLoading(wait,2);
        element.click();
    }

    private void selectCellMember(){
        isLoading(wait,2);
        WebElement cellMember = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ChkCheckInStatus_29173734\"]")));
        isLoading(wait,5);
        cellMember.click();
    }
}
