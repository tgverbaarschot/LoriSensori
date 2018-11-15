// ---------------------------------------- Incudes ----------------------------------------//
#include <lmic.h>
#include <hal/hal.h>
//#include <SPI.h>

#include "Sensoren.h"
#include "Actuatoren.h"
#include "Uplink.h"
#include "Downlink.h"


// ---------------------------------------- Credentials voor ABP bij The Things Network ----------------------------------------//
static const u1_t NWKSKEY[16] = { 0x19, 0xF7, 0x2E, 0xF3, 0xC5, 0x19, 0x6F, 0x92, 0xE7, 0xA2, 0x73, 0xDF, 0xCA, 0xC4, 0x05, 0x06 };
static const u1_t APPSKEY[16] = { 0xD5, 0x53, 0x0B, 0x47, 0xBC, 0xEA, 0x54, 0xFD, 0x2A, 0x21, 0x7B, 0xBD, 0x8E, 0xAF, 0x38, 0x52 };
static const u4_t DEVADDR = 0x26011D15;

static osjob_t alivebericht;
static osjob_t bericht;

int counterbericht;

// ---------------------------------------- Plan TX elke 180 seconden ---------------------------------------- //
const unsigned ALIVE_BERICHT_INTERVAL = 14400; // moet 14400 zijn -> 4 uur
const unsigned BERICHT_INTERVAL = 60;

   
// ---------------------------------------- Pin mapping Dragino LORA GPS Shield ----------------------------------------//
const lmic_pinmap lmic_pins = {
    .nss = 10,
    .rxtx = LMIC_UNUSED_PIN,
    .rst = 9,
    .dio = {2, 6, 7},
};


// ---------------------------------------- onEvent ----------------------------------------// 
void onEvent (ev_t ev) 
{
   downlink.ontvangDownlink();
   os_setTimedCallback(&bericht, os_getTime()+sec2osticks(BERICHT_INTERVAL), berichtfunctie);        //Schedule next transmission --> ack?
}


// ---------------------------------------- Stuur alivebericht een keer in de 4 uur ---------------------------------------- //
/*
void alivefunctie (osjob_t* j)
{
  uplink.berichtTankUl(&alive);

  if (LMIC.opmode & OP_TXRXPEND)                                                              // Check if there is not a current TX/RX job running
    {
      Serial.println(F("Er wordt al een ander bericht verstuurd = 4 uur"));
    } 
    else 
    {        
      LMIC_setTxData2(1,(uint8_t*)&alive, sizeof(alive), 0);                                  // (port 1, 2 bytes, unconfirmed)
      Serial.println(F("Verstuurt alive bericht"));
      os_setTimedCallback(j, os_getTime()+sec2osticks(ALIVE_BERICHT_INTERVAL), alivefunctie); // reschedule job in 5 seconds
    }
    // Next TX is scheduled after TX_COMPLETE event.
}

*/
// ---------------------------------------- Stuur bericht een keer in de 3 minuten en alive een keer in de 3 uur---------------------------------------- //
void berichtfunctie (osjob_t* j)

{
  counterbericht++;
  
  if (LMIC.opmode & OP_TXRXPEND)                                                                                     // Check if there is not a current TX/RX job running
    {                                             
      Serial.println(F("Er wordt al een ander bericht verstuurd = 4 uur"));
    } 
    else if(counterbericht > 60)
    { 
      uplink.berichtTankUl(&alive);       
      LMIC_setTxData2(1,(uint8_t*)&alive, alive.berichtLengte, 0);                                                         // (port 1, bericht, grootte van bericht, unconfirmed)
      Serial.println(F("Verstuurt alive bericht"));
      os_setTimedCallback(j, os_getTime()+sec2osticks(BERICHT_INTERVAL), berichtfunctie);                              // tijdsinterval bericht verzenden
      counterbericht = 0;                                                                                            // reset counter
    }
    else if (counterbericht != 0)
    {
      uplink.kiesBericht();
      LMIC_setTxData2(1,(uint8_t*)berichtPointerLengte.berichtPointer, berichtPointerLengte.berichtLengte, 0);       // (port 1, 2 bytes, unconfirmed) // bepalen hoe groot hetgeen is waar de pointer(uplink.kiesBericht() naar wijst
//      Serial.println(berichtPointerLengte.lengteBericht);
      os_setTimedCallback(j, os_getTime()+sec2osticks(BERICHT_INTERVAL), berichtfunctie);                            // tijdsinterval bericht verzenden
    }
   // Next TX is scheduled after TX_COMPLETE event.
}

/*
 * met deze if kunnen we de twee verschillende berichten versturen zonder dat er iets fout gaat, allen de inhoud van de berichten klopt nog niet, zie comment in Uplink.cpp regel 136
 */

// ---------------------------------------- Setup ----------------------------------------//
void setup() 
{
  Serial.begin(9600);                                   // initialisatie van de seriële poort
  alarmniveauDiesel = 25;
  counterbericht = 0;
  sensoren.SETUP();
  actuatoren.SETUP();  
  os_init();                                            // initilisatie van LMIC
  LMIC_reset();                                         // Resetten van de MAC staat. Sessie en lopende data transfers worden verworpen 
  LMIC_setClockError(MAX_CLOCK_ERROR * 1 / 100);        // Let LMIC compensate for +/- 1% clock error
  LMIC_setSession (0x1, DEVADDR, NWKSKEY, APPSKEY);     // Set parameters voor sessie (ABP)
  LMIC_setLinkCheckMode(0);                             // Disable link check validation
  LMIC.dn2Dr = DR_SF9;                                  // TTN uses SF9 for its RX2 window.
  LMIC_setDrTxpow(DR_SF7,14);                           // Set data rate and transmit power for uplink (note: txpow seems to be ignored by the library) --> SF7!
 // alivefunctie(&alivebericht);
  berichtfunctie(&bericht);
  void (*openSlotPntr)();
  openSlotPntr = actuatoren.openSlot;
 //actuatoren.instellenOpeningstijd(14, 31,openSlotPntr);

 /*
  * Als ik een functie uit de timelib.h of timealarms.h krijg ik een compiler fout. zie comment bij actuatoren.cpp in de declaratie van functie openslot regel 68
  */


}


// ---------------------------------------- Main ----------------------------------------//
void loop()
{
 
  os_runloop_once();
  sensoren.GPSmeting();       // moet deze hier op deze manier?


}


/*
3 x 80 minuten
bij struct een struct maken met grootte en pointer
wrapper functie: void (*pt2Function)(void* pt2Object, char* text)) dit is de functie pointer
*/





















/*
uint32_t counterAliveBericht = 0;
uint32_t counterBericht = 0;

for(;;) 
{
  // Loop is running once per second
  counterAliveBericht++;
  counterBericht++;

   if ( counterAliveBericht >= ALIVE_BERICHT_INTERVAL ) 
   {
    // bericht opbouwen
    counterAliveBericht = 0;
    counterBericht = 0;
   }
}
   if ( counterBericht >= BERICHT_INTERVAL ) 
   {
    // bericht opbouwen
     counterBericht = 0;
   }   */
