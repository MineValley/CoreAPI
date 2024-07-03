# ![Logo](https://cdn.minevalley.eu/branding/logo_64px_cropped.png) - CoreAPI

This api grants important features and access to the internal server-core of MineValleyEU, that is used in any module.

The wiki to this api is still work in progress.

## Maven
Um die CoreAPI in einem Modul nutzbar zu machen, bieten wir eine Maven-Repository via GitHub an.
Falls nicht bereits erledigt, muss zuvor ein Token in der settings.xml hinterlegt werden (mehr dazu unten).

```xml
<repository>
    <id>MineValley-CoreAPI</id>
    <url>https://maven.pkg.github.com/MineValley/CoreAPI</url>
    <snapshots>
        <enabled>true</enabled>
    </snapshots>
</repository>
```

```xml
<dependency>
    <groupId>minevalley.core</groupId>
    <artifactId>api</artifactId>
    <version>LATEST</version>
</dependency>
```

## GitHub-Account verknüpfen
Auch wenn die API öffentlich zugänglich ist, ist für die Verwendung der Repository leider ein GitHub-Account notwendig.
Ist ein solcher vorhanden, muss ein Token erstellt werden:
### Token erstellen
Gehe hierfür in die GitHub-Settings (Rechts oben Profilbild &rarr; 'Settings'). 
<br>
Klicke ganz unten auf 'Developer settings' &rarr; 'Personal access tokens' &rarr; 'Tokens (classic)'.
<br>
Erstelle nun per Klick auf 'Generate new Token' einen neuen Token. Wähle im Dropdown 'Generate new token (classic)' aus.
<br>
Gebe dem Token einen sinnvollen Namen ('MineValley', 'CoreAPI', o. ä.) im Feld 'Note'.
<br>
Bei 'Expiration' wählst du einen geeigneten Zeitraum aus, für den du diesen Token nutzen wirst.
Nach Ablauf des Zeitraums wirst du einen neuen Token erstellen müssen. Du hast auch die Möglichkeit 'No expiration' auszuwählen.
<br>
Setze einen Haken bei 'read:packages' und klicke ganz unten auf 'Generate token'.
<br>
Du kannst den Token nun kopieren.

### Token einfügen
Ist der Token vorhanden, so kannst du ihn in die settings.xml-Datei[^settings] deiner Maven-Installation einfügen.
Die untenstehende Vorlage kann dir dabei helfen. Ersetze dabei USERNAME mit deinem GitHub-Benutzernamen und TOKEN mit dem eben erstellten Token.
```xml
<?xml version="1.0" encoding="UTF-8"?>
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd">
    <servers>
        <server>
            <id>github</id>
            <username>USERNAME</username>
            <password>TOKEN</password>
        </server>
    </servers>
</settings>
```
[^settings]: IntelliJ: Rechtsklick auf die pom.xml eines beliebigen Projekts und wähle 'Create settings.xml'.

## Troubleshooting / FAQ

<details>
    <summary>Ich habe Probleme mit Eclipse</summary>
    Nutze IntelliJ.
</details>


<details>
    <summary>Ich weiß nicht, ob ich den richtigen Benutzernamen ausgewählt habe</summary>
    Du findest den korrekten Github-Nutzernamen auf deinem GitHub-Profil. Bist du dir unsicher, log dich neu ein: 
    Kannst du dich mit dem Benutzernamen einloggen, ist es der richtige.
</details>

<details>
    <summary>Kann ich den Inhalt von &lt;id&gt; frei wählen?</summary>
    Ja. Sowohl in &lt;server&gt; in der settings.xml, als auch bei &lt;repository&gt; in der pom.xml.
</details>

<details>
    <summary>Ich habe alles befolgt, aber die Dependency konnte nicht gefunden werden.</summary>
    Klicke in der rechten Seitenleiste auf 'Maven' und dann links oben auf den 'Reload All Maven Projects'-Button. 
    Funktioniert es weiterhin nicht, klicke links oben im Fenster auf 'File' &rarr; 'Invalidate Caches ...' &rarr; 'Invalidate and Restart'.
</details>