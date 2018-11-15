// ---------------------------------------- Downlink berichten ----------------------------------------//
#include "Downlink.h"
#include "Sensoren.h"
#include "Actuatoren.h"

// ---------------------------------------- Variabelen ----------------------------------------//


// ---------------------------------------- Ontvang bericht ----------------------------------------//
void Downlink::ontvangDownlink()
{
  Serial.println(F("EV_TXCOMPLETE (includes waiting for RX windows)"));
    if (LMIC.txrxFlags & TXRX_ACK)
      Serial.println(F("Acknowledge ontvangen"));
    if (LMIC.dataLen) 
    {
      uint8_t downlink[LMIC.dataLen];
      for (int i = 0; i < LMIC.dataLen; i++)
      {
        memcpy(&downlink[i],&(LMIC.frame+LMIC.dataBeg)[i],LMIC.dataLen);
      }  

    Serial.print("Eerste byte: ");
    Serial.println(downlink[0]);                               
    Serial.print("Tweede byte: "); 
    Serial.println(downlink[1]);
    Serial.print("Derde byte: "); 
    Serial.println(downlink[2]);

    switch (downlink[0])                                                              // byte eerste downlink is de id van het downlinkbericht. Vanuit hier wordt besloten wat er gedaan moet worden.                                                                                                                                                                           
    {
    case dlIdSlotstandDl:
      if(downlink[1] == 00 && (sensoren.slotstandmeting()== 01 || sensoren.slotstandmeting()== 02 ))
      {
        actuatoren.sluitSlot();
      }
      else if (downlink[1] == 01 && (sensoren.slotstandmeting()== 00 || sensoren.slotstandmeting()== 02 ))
      {
        actuatoren.openSlot();
      }
    break;
    case dlIdDieselniveauDl:
      sensoren.alarmNiveauInstellen(downlink[1]);
    break;
    case dlIdOpeningstijdDl:
      void (*openSlotPntr)();
      openSlotPntr = &actuatoren.openSlot;
      actuatoren.instellenOpeningstijd(downlink[1], downlink[2],openSlotPntr);
    break;
    case dlIdSluitingstijdDl:
      void (*sluitSlotPntr)();
      sluitSlotPntr = &actuatoren.sluitSlot;
      actuatoren.instellenSluitingstijd(downlink[1], downlink[2], sluitSlotPntr);
    break;
    default:
    //
    break;
    }
  }
}        
