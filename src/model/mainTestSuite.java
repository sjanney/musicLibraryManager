package model;
import model.tests.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        albumTests.class,
        DataConverterTest.class,
        musicStoreTest.class,
        parserTests.class,
        playlistTests.class,
        songTests.class,
        userTest.class,
        userDatabaseTest.class
})
public class mainTestSuite {}