package com.example.seleniumspring.resource_test;

import com.example.seleniumspring.base.SpringBaseTestNGTests;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.FileCopyUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class ResourceTests extends SpringBaseTestNGTests {

    Logger logger = LoggerFactory.getLogger(ResourceTests.class);

    @Value("${screenshot.path}/../data/sample-file.txt")
    Path sampleFilePath;
    @Value("${screenshot.path}/../data")
    Path dataPath;
    @Lazy
    @Autowired
    ResourceLoader loader;
    @Value("classpath:data/testdata.csv")
    private Resource csvResource1;
    @Value("file:src/test/resources/data/testdata.csv")
    private Resource csvResource2;
    @Value("https://www.w3.org/TR/2003/REC-PNG-20031110/iso_8859-1.txt")
    private Resource onlineResource;
    @Value("classpath:data/files_name.csv")
    private Resource csvResource3;

    @Test
    public void resourceTest1() throws IOException {
        System.out.println("----------- CSV File Data -----------");
        Files.readAllLines(csvResource1.getFile().toPath()).forEach(System.out::println);
        System.out.println("----------- CSV File Data -----------");
        Files.readAllLines(csvResource2.getFile().toPath()).forEach(System.out::println);
        System.out.println("----------- Online File -----------");
        System.out.println(new String(onlineResource.getInputStream().readAllBytes()));
        FileCopyUtils.copy(onlineResource.getInputStream(), Files.newOutputStream(sampleFilePath, StandardOpenOption.CREATE));
    }

    @Test(dataProvider = "linksAndFiles")
    public void resourceTest2(String url, String outFile) throws IOException {
        logger.info("To Be Fetched From URL --> " + url);
        logger.info("To Be Saved In --> " + outFile);
        FileCopyUtils.copy(
                loader.getResource(url).getInputStream(),
                Files.newOutputStream(dataPath.resolve(outFile), StandardOpenOption.CREATE)
        );
    }

    @DataProvider(name = "linksAndFiles")
    public Object[][] fileNameProviders() throws IOException {
        Object[][] _obj = null;
        try {
            _obj = Files.readAllLines(csvResource3.getFile().toPath())
                    .stream()
                    .map(_line -> _line.split(","))
                    .toArray(Object[][]::new);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return _obj;
    }

}
