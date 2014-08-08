package no.web.config;

import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.MapMaker;
import com.google.common.io.Files;
import com.google.common.io.Resources;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Named;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Singleton
@Startup
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class TestappConfig {

    private static final Logger log = LoggerFactory.getLogger(TestappConfig.class);

    private static final String CONFIG_FILENAME = "testapp.properties";

    private final Map<String, String> config = new MapMaker().makeMap();

    private long lastModified = 0;

    @PostConstruct
    public void init() {
        log.info("¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤ Loading config from classpath");
        Properties properties = new Properties();
        try {
            properties.load(Resources.getResource(TestappConfig.class, CONFIG_FILENAME).openStream());
        } catch (IOException e) {
            log.error("Failed to load config from classpath", e);
        }
        properties.entrySet().stream().forEach(e -> config.put(String.valueOf(e.getKey()), String.valueOf(e.getValue())));
        loadConfig();
    }

    //@Schedule(minute = "*", hour = "*",  persistent = false)
    public void loadConfig() {
        String jbossConfDir = System.getProperty("jboss.server.config.dir");
        if (jbossConfDir == null) {
            log.error("Skipping refresh of config: JBoss server conf dir not found.");
            return;
        }
        String confFilename = jbossConfDir + File.separator + CONFIG_FILENAME;
        File f = new File(confFilename);
        if (!f.isFile()) {
            log.debug("Skipping refresh of config. File '{}' not found.", confFilename);
            return;
        }
        if (f.lastModified() <= lastModified) {
            log.debug("Skipping refresh of config. File '{}' is not modified.", confFilename);
            return;
        }
        log.info("Refreshing config from {}", f);
        Properties properties = new Properties();
        try {
            properties.load(Files.newReader(f, Charsets.UTF_8));
            properties.entrySet().stream().forEach(e -> config.put(String.valueOf(e.getKey()), String.valueOf(e.getValue())));
        } catch (IOException e) {
            log.error("Failed to refresh config", e);
        }
    }
}
