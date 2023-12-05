package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    /*
        .properties uzantili dosyaya erisebilmek icin Properties class'indan obje olusturmamiz gerekir
      bu olusturdugumuz obje ile akisa aldigimiz dosya yolunu properties.load(fis) methodu ile propeties
      dosyasindaki bilgileri objemize yukler ve properties dosyasindaki key degerini return ederiz.
      Bunu yapmak icin parametreli bir method olusturur girdigimiz key'in degerini bize dondurur
     */
    static Properties properties;
    static {
        try {
        FileInputStream fis = new FileInputStream("configuration.properties");
        properties = new Properties();
        properties.load(fis);//-->fis'in okudugu bilgileri properties'e yukler
    } catch (IOException e) {
        throw new RuntimeException(e);
    }

    }

    public static String getProperty(String key){

        return properties.getProperty(key);//-->String olarak girdigim key'in degerini return eder

    }

}
