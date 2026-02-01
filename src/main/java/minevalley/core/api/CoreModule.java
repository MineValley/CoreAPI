package minevalley.core.api;

import lombok.Getter;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Getter
@SuppressWarnings("unused")
public abstract class CoreModule {

    private final Module moduleDescription;

    public CoreModule() {
        final Class<? extends CoreModule> clazz = getClass();
        if (!clazz.isAnnotationPresent(Module.class)) {
            throw new IllegalArgumentException("Module annotation is missing in module '" + clazz.getSimpleName() + "'");
        }
        this.moduleDescription = clazz.getAnnotation(Module.class);
    }

    /**
     * Is called when the module is enabled.
     */
    public void onEnable() {
        // do nothing
    }

    /**
     * Is called when the module is disabled.
     */
    public void onDisable() {
        // do nothing
    }

    public void onCleanup() {
        // do nothing
    }
g
    /**
     * Gets the version of this module.
     *
     * @return the version
     */
    @Nonnull
    @Contract(pure = true)
    public String getVersion() {
        return getClass().getPackage().getImplementationVersion();
    }

    @Nonnull
    @Contract(pure = true)
    public Developer[] getDevelopers() {
        try {
            Properties props = loadPomProperties();
            if (props == null) return new Developer[0];
            
            String pomPath = "META-INF/maven/" + props.getProperty("groupId") + "/" + props.getProperty("artifactId") + "/pom.xml";
            try (InputStream pomStream = getClass().getClassLoader().getResourceAsStream(pomPath)) {
                if (pomStream == null) return new Developer[0];

                Document doc = createSecureDocumentBuilder().parse(pomStream);
                NodeList developerNodes = doc.getElementsByTagName("developer");
                List<Developer> developers = new ArrayList<>();

                for (int i = 0; i < developerNodes.getLength(); i++) {
                    Element dev = (Element) developerNodes.item(i);
                    String name = getTextContent(dev, "name", "Unknown");
                    String uuid = "00000000-0000-0000-0000-000000000000";
                    String discord = "";

                    NodeList propsNodes = dev.getElementsByTagName("properties");
                    if (propsNodes.getLength() > 0) {
                        Element properties = (Element) propsNodes.item(0);
                        uuid = getTextContent(properties, "uuid", uuid);
                        discord = getTextContent(properties, "discord", discord);
                    }
                    developers.add(new Developer(name, uuid, discord));
                }
                return developers.toArray(new Developer[0]);
            }
        } catch (Exception e) {
            System.err.println("Warning: Could not load developers from pom.xml: " + e.getMessage());
            return new Developer[0];
        }
    }

    private Properties loadPomProperties() {
        String packageName = getClass().getPackage().getName();
        String[] parts = packageName.split("\\.");
        
        for (int i = Math.min(parts.length, 4); i >= 1; i--) {
            String groupId = String.join(".", java.util.Arrays.copyOfRange(parts, 0, i));
            String lastPart = parts[parts.length - 1];
            String[] artifactIds = (i < parts.length && !parts[i].equals(lastPart)) 
                ? new String[]{parts[i], lastPart} 
                : new String[]{lastPart};
            
            for (String artifactId : artifactIds) {
                String path = "META-INF/maven/" + groupId + "/" + artifactId + "/pom.properties";
                try (InputStream stream = getClass().getClassLoader().getResourceAsStream(path)) {
                    if (stream != null) {
                        Properties props = new Properties();
                        props.load(stream);
                        return props;
                    }
                } catch (Exception e) {
                    System.err.println("Warning: Error reading pom.properties: " + e.getMessage());
                }
            }
        }
        return null;
    }

    private DocumentBuilder createSecureDocumentBuilder() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
        factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
        factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
        factory.setXIncludeAware(false);
        factory.setExpandEntityReferences(false);
        return factory.newDocumentBuilder();
    }

    private String getTextContent(Element parent, String tagName, String defaultValue) {
        NodeList nodes = parent.getElementsByTagName(tagName);
        if (nodes.getLength() > 0) {
            String content = nodes.item(0).getTextContent();
            return content != null ? content.trim() : defaultValue;
        }
        return defaultValue;
    }
}