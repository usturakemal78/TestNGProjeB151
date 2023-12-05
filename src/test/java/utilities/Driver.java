package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
    /*
    POM(Page Object Model)
        Test senaryolarinin daha az kod ile yazilmasina ve bakiminin daha kolay yapilmasina
        olanak saglayan yazilim test yontemidir. TestNG de ve CUCUMBER frameworklerinde POM kalibi kullanilir.
     */

public class Driver {
    private Driver(){
        /*
       Driver class'indan obje olusturmanin onunce gecebilmek icin
       default constructor'i private yaparak bunu engellemis oluruz. Bu kaliba da Singleton pattern denir
       */
        // default olan constructor'i private yaparak baska package altinda  bu class'tan obje olusturmasını engelliyoruz. Singleton pattern
//--> new'lenemez.
//--> bunun icin kendi class'ina default constructor yazdik.
//--> bu default constructor'in access modifier'i
//--> private yapildigi icin baska class'larda Driver class'indan obje olusturulamaz.
    }
    static WebDriver driver;

    public static WebDriver getDriver(){
         /*
            Driver 'i her cagirdigimizda yeni bir pencere acilmasinin onune gecmek icin
         if blogu icinde Eger driver'a deger ATANMAMISSA deger ata, eger deger atanmamissa
         Driver'i ayni sayfada return et.
           */
        /*
        Properties dosyasinda key olarak belirttigimiz browser'a asagidaki gibi hangi degeri
        belirtirsek testlerimiz o browser ile calisir
         */

        if(driver == null) {//--> Driver'a deger atanmamissa
            switch (ConfigReader.getProperty("browser")){
                case "chrome" :
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver= new EdgeDriver();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver= new FirefoxDriver();
                    break;

                case  "safari" :
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;

                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
        return driver;

    }
    public static void closeDriver(){
        if(driver !=null) {//-->Driver'a deger atanmissa, bos degilse
            driver.close();
            driver = null;//-->Driver'i kapattiktan sonra bosalt
        }
    }
    public static void quitDriver(){
        if(driver !=null) {//-->Driver'a deger atanmissa, bos degilse
            driver.quit();
            driver = null;//-->Driver'i kapattiktan sonra bosalt
        }
    }


}
