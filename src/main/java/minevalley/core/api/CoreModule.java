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
        try (InputStream pomStream = getClass().getClassLoader().getResourceAsStream("META-INF/maven/minevalley.core/api/pom.xml")) {
            if (pomStream == null) {
                return new Developer[0];
            }

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Secure XML parsing - prevent XXE attacks
            factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
            factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            factory.setXIncludeAware(false);
            factory.setExpandEntityReferences(false);
            
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(pomStream);
            doc.getDocumentElement().normalize();

            NodeList developerNodes = doc.getElementsByTagName("developer");
            List<Developer> developers = new ArrayList<>();

            for (int i = 0; i < developerNodes.getLength(); i++) {
                Element developerElement = (Element) developerNodes.item(i);
                
                String name = getElementTextContent(developerElement, "name", "Unknown");
                String uuid = "00000000-0000-0000-0000-000000000000";
                String discord = "";

                // Try to get properties
                NodeList propertiesNodes = developerElement.getElementsByTagName("properties");
                if (propertiesNodes.getLength() > 0) {
                    Element properties = (Element) propertiesNodes.item(0);
                    uuid = getElementTextContent(properties, "uuid", uuid);
                    discord = getElementTextContent(properties, "discord", discord);
                }

                developers.add(new Developer(name, uuid, discord));
            }

            return developers.toArray(new Developer[0]);
        } catch (Exception e) {
            // If we can't read the pom.xml, return empty array
            // This could happen in development when running from IDE without packaged JAR
            System.err.println("Warning: Could not load developers from pom.xml: " + e.getMessage());
            return new Developer[0];
        }
    }

    private String getElementTextContent(Element parent, String tagName, String defaultValue) {
        NodeList nodes = parent.getElementsByTagName(tagName);
        if (nodes.getLength() > 0) {
            String content = nodes.item(0).getTextContent();
            return content != null ? content.trim() : defaultValue;
        }
        return defaultValue;
    }
}