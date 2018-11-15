// ---------------------------------------- Sensoren ----------------------------------------//
#include "Sensoren.h"

NMEAGPS gps;                    // This parses the GPS characters
gps_fix fix;                    // This holds on to the latest values

// ---------------------------------------- Lezing analoge sensoren ----------------------------------------//
const int ACCUNIVEAUPIN = A0;       // inputpin om de spanning van de batterij te meten
const int DIESELNIVEAUPIN = A1;     // inputpin voor de potmeter die het dieselniveau simuleert
const int VOLTZONNEPANEELPIN = A2;  // inputpin om de spanning van het zonnepaneel te meten
const int AMPZONNEPANEELPIN = A3;   // inputpin om de stroom die geleverd wordt door het zonnepaneel te meten


// ---------------------------------------- Lezen digitale input ----------------------------------------//
const int SLOTOPENPIN = 3;         // simulatie eindstandmelder slot open, kijkt of de groene led brandt
const int SLOTDICHTPIN = 5;        // simulatie eindstandmelder slot dicht, kijkt of de rode led brandt


// ---------------------------------------- Constanten ----------------------------------------//
const int DIESELNIVEAUMAX = 1024; // initialiseert de maximale waarde van de potmeter/dieselniveau
const int DIESELNIVEAUMIN = 0;    // initialiseert de minimale waarde van de potmeter/dieselniveau
const int ACCUNIVEAUMAX = 920;    // initialiseert de maximale waarde van het accuniveau
const int ACCUNIVEAUMIN = 765;    // initialiseert de minimale waarde van de het accuniveau


// ---------------------------------------- Variabelen ----------------------------------------//
int dieselniveau;                // variabele om de inkomende waarde van het dieselniveau op te slaan                              
int accuniveau;                  // variabele om de inkomende waarde van het accuniveau op te slaan
int vermogenZonnepaneel;         // Byte om de de uitkomst van de som VOLTZONNEPANEEL*AMPZONNEPANEEL op te slaan
int alarmniveauDiesel;           // Byte om het door de gebruiker in te stellen minimum dieselniveau op te slaan
/*
int latGraden;       // byte 1: graden, byte 2: minuten, byte 3: seconden, byte 4: 10e boogseconde
int latMinuten;
int latSeconden; 
int latBoogSeconden;
int lonGraden;         // byte 1: graden, byte 2: graden, byte 3: minuten, byte 4: boogseconde, byte 5: 10e boogseconde
int lonMinuten;
int lonSeconden; 
int lonBoogSeconden;
*/
int slotOpen;
int slotDicht;


// ---------------------------------------- SETUP ----------------------------------------//
void Sensoren::SETUP()
{
  pinMode(ACCUNIVEAUPIN, INPUT);
  pinMode(DIESELNIVEAUPIN, INPUT);
  pinMode(VOLTZONNEPANEELPIN, INPUT);
  pinMode(AMPZONNEPANEELPIN, INPUT);
  pinMode(SLOTOPENPIN, INPUT);
  pinMode(SLOTDICHTPIN, INPUT);
  gpsPort.begin(9600);                                  // initialisatie van de GPS poort (Serial1, gedefinieerd in library)
}


// ---------------------------------------- Accuniveau doorsturen ----------------------------------------//
byte Sensoren::accuniveaumeting()
{
  accuniveau = analogRead(ACCUNIVEAUPIN);
  accuniveau = map(accuniveau, ACCUNIVEAUMIN, ACCUNIVEAUMAX, 0, 101); // waarde omzetten naar een getal tussen 0 en 100%
  return accuniveau;                                                 // geeft het accuniveau terug
}


// ---------------------------------------- Accuniveau te laag doorsturen ----------------------------------------//
byte Sensoren::accuAlarm(byte accuniveau)
{
  if (accuniveau < 25)
    {
      return 01;                                         // geeft 01 als het accuniveau minder dan 25% is        
    }
  return 00;                                             // geeft 00 als het accuniveau meer dan 25% is
}


// ---------------------------------------- Dieselniveau doorsturen ----------------------------------------//
byte Sensoren::dieselniveaumeting()
{
  dieselniveau = analogRead(DIESELNIVEAUPIN);
  dieselniveau = map(dieselniveau, DIESELNIVEAUMIN, DIESELNIVEAUMAX, 0, 101);   // waarde omzetten naar een getal tussen 0 en 100%
  return dieselniveau;                                                          // geeft het dieselniveau terug
}


// ---------------------------------------- Minimum dieselniveau instellen ----------------------------------------//
byte Sensoren::alarmNiveauInstellen(byte downlinkDieselniveau)                 // waarde uit downlink om het niveau aan te passen 0..100
{
    alarmniveauDiesel = downlinkDieselniveau;
    return alarmniveauDiesel;                                                  //alarmniveauDiesel is gelijk aan het door de gebruiker ingestelde niveau
}


// ---------------------------------------- Dieselniveau alarm doorgeven ----------------------------------------//
byte Sensoren::dieselalarmNiveau()
{
 if (dieselniveaumeting() <= alarmniveauDiesel)
    {
      return 01;                                                              // geeft 01 als het dieselniveau <= aan het ingestelde alarmniveau
    }
  return 00;                                                                  // geeft 00 als het dieselniveau > aan het ingestelde alarmniveau
}


// ---------------------------------------- Vermogen zonnepaneel doorsturen ----------------------------------------//
byte Sensoren::vermogenZonnepaneelmeting()
{
  int voltZonnepaneel = analogRead(VOLTZONNEPANEELPIN); // lees analoog in voor volt zonnepaneel 1V voor elke 5V input
  int ampZonnepaneel = analogRead(AMPZONNEPANEELPIN);   // lees analoog in voor amp 1V voor elke amp input
  float volt = voltZonnepaneel * (5.0 / 1024.0) * 5.0;
  float amp = ampZonnepaneel * (5.0 / 1024.0);
  int watt = volt * amp * 100;                          // watt is vermogen * 100 om 2 decimalen precisie te houden na cast to byte
  vermogenZonnepaneel = lowByte(watt);                  // vermogen zonnepaneel is byte waarde van watt. zonnepanelen geven max 2W dus byte 200
  return vermogenZonnepaneel;
}


// ---------------------------------------- Slot open/dicht lezen ----------------------------------------//
byte Sensoren::slotstandmeting()
{
  slotOpen = digitalRead(SLOTOPENPIN);
  slotDicht = digitalRead(SLOTDICHTPIN);
  
  if (slotOpen == HIGH && slotDicht == LOW)                                                         // als het slot open is wordt er 01 gestuurd
  {
    return 01;
  }
  else if (slotOpen == LOW && slotDicht == HIGH)                                                    // als het slot dicht is wordt er 00 gestuurd
  {
    return 00;
  }
  else if (slotOpen == HIGH && slotDicht == HIGH || slotOpen == LOW && slotDicht == LOW)            // slotopenpin en slotdichtpin kunnen niet dezelfde waarde hebben, er wordt een foutmelding 02 gestuurd 
 {                                                                                  
    return 02;
  }
}


// ---------------------------------------- GPS waarden lezen ----------------------------------------//
void Sensoren::GPSmeting()
{
  if (gps.available( gpsPort )) {
    fix = gps.read(); 
  }   
} // GPSloop
