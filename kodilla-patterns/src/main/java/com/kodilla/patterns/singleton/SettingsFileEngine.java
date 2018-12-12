package com.kodilla.patterns.singleton;

public final class SettingsFileEngine {

    private static SettingsFileEngine settingsFileEngineInstance = null; // Będziemy je inicjować dopiero w przypadku, gdy ktoś będzie próbował go użyć (tak zwane lazy instantiating — powoływanie obiektu do życia dopiero przy próbie użycia)
    private SettingsFileEngine() { // Następnie "ukryjemy" konstruktor bezparametrowy po to, aby nikt nie mógł samodzielnie utworzyć obiektu naszej klasy.
    }
    public static SettingsFileEngine getInstance() { // Kolejna modyfikacja naszej klasy będzie polegała na dodaniu statycznej metody getInstance() — nazwa tej metody jest zwyczajowo przyjęta we wzorcu Singleton
        if (settingsFileEngineInstance == null) {
            synchronized(SettingsFileEngine.class) { // drugie sprawdzenie odbywa się wewnątrz bloku synchronized(), dzięki czemu będziemy mieli pewność, że nie wystąpi równoczesne utworzenie osobnych obiektów Singletona przez równolegle działające wątki aplikacji
                if (settingsFileEngineInstance == null) {
                    settingsFileEngineInstance = new SettingsFileEngine();
                }
            }
        }
        return settingsFileEngineInstance;
    }



    private String fileName = "";


    public String getFileName() {
        return fileName;
    }

    public void open(final String fileName) {
        this.fileName = fileName;
        System.out.println("Opening the settings file");
    }

    public void close() {
        this.fileName = "";
        System.out.println("Closing the settings file");
    }

    public boolean loadSettings() {
        System.out.println("Loading settings from file");
        return true;
    }

    public boolean saveSettings() {
        System.out.println("Saving settings to file");
        return true;
    }
}
