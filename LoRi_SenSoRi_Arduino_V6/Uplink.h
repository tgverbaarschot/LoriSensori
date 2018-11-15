#ifndef Uplink_h
#define Uplink_h

#include <lmic.h>
#include <hal/hal.h>
#include <arduino.h>

// ---------------------------------------- Id's definiëren ----------------------------------------//
const int ulIdTankUl = 0x00;
const int ulIdATankenUl = 0x01;
const int ulIdADieselniveauUl = 0x02;
const int ulIdAAccuniveauUl = 0x03;
const int ulIdWSlotstandUl = 0x04;
const int ulIdWDieselniveauUl = 0x05;
const int ulIdCheck = 0x06;

// ---------------------------------------- Tankbericht ----------------------------------------//
 typedef struct tankUl
 {
    byte ulId;                // Identificatienummer bericht = 0x00
    byte dieselniveau;        // 0…1023 == 0%...100%
    byte slotstand;           // 0 = dicht, 1 = open
    byte accuspanning;        // 765…920 == 0%...100%
    byte zonnepaneel;         // watt/hour
    byte latGraden;           // latitude graden
    byte latMinuten;          // latitude minuten
    byte latSeconden;         // latitude seconden
    byte latTiendeSeconden;   // latitude 10e boogseconde
    byte lonGraden;           // longitude graden
    byte lonMinuten;          // longitude minuten
    byte lonSeconden;         // longitude seconden
    byte lonTiendeSeconden;   // longitude 10e boogseconde
    uint8_t berichtLengte;        // lengte van bericht in bytes
}TankUl;


// ---------------------------------------- Alarm dieselniveau te laag ----------------------------------------//
typedef struct aTankUl
{
    byte ulId;                // Identificatienummer bericht = 0x01
    byte dieselniveau;        // 0…1023 == 0%...100%
    uint8_t berichtLengte;        // lengte van bericht in bytes
}ATankUl; 


// ---------------------------------------- Alarm dieselniveauverlaging tijdens sluitingstijd ----------------------------------------//
typedef struct aDieselniveauUl
{
    byte ulId;                // Identificatienummer bericht = 0x02
    byte dieselniveau;        // 0…1023 == 0%...100%
    byte slotstand;           // 0 = dicht, 1 = open
    byte latGraden;           // latitude graden
    byte latMinuten;          // latitude minuten
    byte latSeconden;         // latitude seconden
    byte latTiendeSeconden;   // latitude 10e boogseconde
    byte lonGraden;           // longitude graden
    byte lonMinuten;          // longitude minuten
    byte lonSeconden;         // longitude seconden
    byte lonTiendeSeconden;   // longitude 10e boogseconde
    uint8_t berichtLengte;        // lengte van bericht in bytes
}ADieselniveauUl; 


// ---------------------------------------- Alarm accuniveau te laag ----------------------------------------//
typedef struct aAccuniveauUl
{
    byte ulId;                // Identificatienummer bericht = 0x03
    byte accuspanning;        // 765…920 == 0%...100%
    uint8_t berichtLengte;        // lengte van bericht in bytes
}AAccuniveauUl;


// ---------------------------------------- Bericht slotstand gewijzigd ----------------------------------------//
typedef struct wSlotstandUl
{
    byte ulId;                // Identificatienummer bericht = 0x04
    byte slotstand;           // 0 = dicht, 1 = open
    uint8_t berichtLengte;        // lengte van bericht in bytes
}WSlotstandUl; 


// ---------------------------------------- Bericht dieselniveau gewijzigd ----------------------------------------//
typedef struct wDieselniveauUl
{
    byte ulId;                // Identificatienummer bericht = 0x005
    byte dieselniveau;        // 0…1023 == 0%...100%
    uint8_t berichtLengte;        // lengte van bericht in bytes
}WDieselniveauUl;


// ---------------------------------------- Bericht dieselniveau gewijzigd ----------------------------------------//
typedef struct checkBericht
{
    byte ulId;                // Identificatienummer bericht = 0x006
    uint8_t berichtLengte;        // lengte van bericht in bytes
}CheckBericht;


// ---------------------------------------- lengte en pointer in struct ----------------------------------------//
typedef struct berichtPointerLengte
{
    uint8_t *berichtPointer;                // pointer naar bericht
    uint8_t berichtLengte;                 // lengte van het bericht
}BerichtPointerLengte;


// ---------------------------------------- Class Uplink ----------------------------------------//
class Uplink
{
  public:
  Uplink();
  uint8_t berichtTankUl(TankUl *p);
  uint8_t berichtATankUl(ATankUl *p);
  uint8_t berichtADieselniveauUl(ADieselniveauUl *p);
  uint8_t berichtAAccuniveauUl(AAccuniveauUl *p);
  uint8_t berichtWSlotstandUl(WSlotstandUl *p);
  uint8_t berichtWDieselniveauUl(WDieselniveauUl *p);
  void BerichtCheck(CheckBericht *p);
  void kiesBericht();
};

extern TankUl alive;
extern ATankUl tankenAlarm;
extern ADieselniveauUl verlagingDieselniveauAlarm;
extern AAccuniveauUl accuniveauAlarm;
extern WSlotstandUl slotstandWijziging;
extern WDieselniveauUl alarmniveauDieselWijziging;
extern CheckBericht checkBericht;
extern BerichtPointerLengte berichtPointerLengte;
//extern Check dlCheck;

extern Uplink uplink;

#endif //Uplink.h












































// void SendLPWANMs(byte MsgID); // bekijken of dit erin moet
