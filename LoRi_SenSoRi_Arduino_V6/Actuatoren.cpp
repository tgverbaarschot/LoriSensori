// ---------------------------------------- Actuatoren ----------------------------------------//
#include "Actuatoren.h"

// ---------------------------------------- Lezing digitale output ----------------------------------------//
const int SLOTBESTURING = 4; // outputpin voor de leds die aangeven of het slot open of dicht is


// ---------------------------------------- Constanten ----------------------------------------//
const int SECONDENOPEN = 0;     // seconden dat het slot open moet, is niet instelbaar
const int SECONDENDICHT = 10;   // seconden dat het slot dicht moet, is niet instelbaar


// ---------------------------------------- Variabelen ----------------------------------------//
int uurOpen = 19;               // uur dat het slot open moet, waarde is in te stellen en komt uit de downlink
int minutenOpen = 00;           // minuten dat het slot open moet, waarde is in te stellen en komt uit de downlink
int uurDicht = 19;              // uur dat het slot dicht moet, waarde is in te stellen en komt uit de downlink
int minutenDicht = 00;          // minuten dat het slot dicht moet, waarde is in te stellen en komt uit de downlink


// ---------------------------------------- SETUP ----------------------------------------//
static void Actuatoren::SETUP()
{
  pinMode(SLOTBESTURING, OUTPUT);
  setTime(14,29,50,7,11,18);                  // set datum en tijd: 07-11-2018, 14.00 --> veranderen naar juiste tijd!!
//  instellenOpeningstijd(int uurOpen, int minutenOpen)  ;
 // instellenSluitingstijd(int uurDicht, int minutenDicht); 

}


// ---------------------------------------- Instellen openingstijd door de weeks ----------------------------------------//

static void Actuatoren::instellenOpeningstijd(int uurOpen, int minutenOpen, void (*openSlotPntr)())             
{
  /*Alarm.alarmOnce(dowMonday, uurOpen, minutenOpen, SECONDENOPEN, openSlotPntr);  
  Alarm.alarmOnce(dowTuesday, uurOpen, minutenOpen, SECONDENOPEN, openSlotPntr);  
  Alarm.alarmOnce(dowWednesday, uurOpen, minutenOpen, SECONDENOPEN, openSlotPntr);  
  Alarm.alarmOnce(dowThursday, uurOpen, minutenOpen, SECONDENOPEN, openSlotPntr);  
  Alarm.alarmOnce(dowFriday, uurOpen, minutenOpen, SECONDENOPEN, openSlotPntr);  */
}


// ---------------------------------------- Instellen sluitingstijd door de weeks ----------------------------------------//

void Actuatoren::instellenSluitingstijd(int uurDicht, int minutenDicht, void (*sluitSlotPntr)())
{
  /*Alarm.alarmOnce(dowMonday, uurDicht, minutenDicht, SECONDENDICHT, sluitSlotPntr);  
  Alarm.alarmOnce(dowTuesday, uurDicht, minutenDicht, SECONDENDICHT, sluitSlotPntr); 
  Alarm.alarmOnce(dowWednesday, uurDicht, minutenDicht, SECONDENDICHT, sluitSlotPntr);  
  Alarm.alarmOnce(dowThursday, uurDicht, minutenDicht, SECONDENDICHT, sluitSlotPntr);
  Alarm.alarmOnce(dowFriday, uurDicht, minutenDicht, SECONDENDICHT, sluitSlotPntr);*/
}


// ---------------------------------------- Functie openen slot ----------------------------------------//
void Actuatoren::openSlot()  // niet static, miss wrapper?
{
  if (day() == 4 && hour() == 14 && minute() == 31) // Als we onderdelen van TimeLib.h gebruiken krijgen we een foutmelding:
  /*
   * C:\Users\TV\Documents\Arduino\libraries\arduino-lmic-master\src\lmic\lmic.c: In function 'aes_cipher.part.1':

C:\Users\TV\Documents\Arduino\libraries\arduino-lmic-master\src\lmic\lmic.c:190:1: internal compiler error: Segmentation fault

 }

 ^

Please submit a full bug report,

with preprocessed source if appropriate.

See <http://gcc.gnu.org/bugs.html> for instructions.

lto-wrapper.exe: fatal error: C:\Program Files\WindowsApps\ArduinoLLC.ArduinoIDE_1.8.15.0_x86__mdqgnx93n4wtt\hardware\tools\avr/bin/avr-gcc returned 1 exit status

compilation terminated.

c:/program files/windowsapps/arduinollc.arduinoide_1.8.15.0_x86__mdqgnx93n4wtt/hardware/tools/avr/bin/../lib/gcc/avr/5.4.0/../../../../avr/bin/ld.exe: error: lto-wrapper failed

collect2.exe: error: ld returned 1 exit status

exit status 1
Fout bij het compileren voor board Arduino/Genuino Mega or Mega 2560
   */
  {
  digitalWrite (SLOTBESTURING, HIGH);
  Serial.println(F("Alarm: - slot open"));
  }
}

// ---------------------------------------- Functie sluiten slot ----------------------------------------//
void Actuatoren::sluitSlot() // niet static, miss wrapper?
{
  digitalWrite (SLOTBESTURING, LOW);
  Serial.println(F("Alarm: - slot dicht"));
}
































// ---------------------------------------- Slot open/dicht zetten ----------------------------------------//
/*
 * voorwaarde: slot is open wanneer het dicht wordt gezet, niet dicht en omgekeerd
 * 
void Actuatoren::bestuurSlot()
{
   if (sensoren.slotstandmeting() == 00 && byte waarde == 01 || downlink[1] == 01)          // waarde uit downlink 
   {
     SLOTOPEN;
   }
   else if (sensoren.slotstandmeting() == 01 && byte waarde == 00 || downlink[1] == 00)     // waarde uit downlink
   {
     SLOTDICHT;
   }  
}*/
