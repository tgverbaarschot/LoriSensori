#ifndef Downlink_h
#define Downlink_h

#include <lmic.h>
#include <hal/hal.h>
#include <arduino.h>


// ---------------------------------------- Id's definiëren ----------------------------------------//
const int dlIdSlotstandDl = 0x00;
const int dlIdDieselniveauDl = 0x01;
const int dlIdOpeningstijdDl = 0x02;
const int dlIdSluitingstijdDl = 0x03;


// ---------------------------------------- Class downlink ----------------------------------------//
class Downlink
{
  public:
  Downlink();
  void ontvangDownlink();
};

extern Downlink downlink;

#endif //Downlink.h



















/*
// ---------------------------------------- Bericht slot openen/sluiten ----------------------------------------//
typedef struct slotstandDl
{
    byte dl;           // Downlinknummer zoals beschreven in de tabel hierboven (00)
    byte waarde;       // De nieuwe waarde van de slotstand (00 is dicht, 01 is open)
}SlotstandDl;


// ---------------------------------------- Bericht instellen dieselniveau voor tankalarm ----------------------------------------//
typedef struct dieselniveauDl
{
    byte dl;           // Downlinknummer zoals beschreven in de tabel hierboven (01)
    byte waarde [3];   // De nieuwe waarde van de parameter die moet worden veranderd
}DieselniveauDl;


// ---------------------------------------- Bericht instellen openingstijd ----------------------------------------//
typedef struct openingstijdDl
{
    byte dl;           // Downlinknummer zoals beschreven in de tabel hierboven (02)
    byte waarde [3];   // De nieuwe waarde van de parameter die moet worden veranderd
}OpeningstijdDl;


// ---------------------------------------- Bericht instellen sluitingstijd ----------------------------------------//
typedef struct sluitingstijdDl
{
    byte dl;           // Downlinknummer zoals beschreven in de tabel hierboven (03)
    byte waarde [3];   // De nieuwe waarde van de parameter die moet worden veranderd
}SluitingstijdDl;

*/












































// void SendLPWANMs(byte MsgID); // bekijken of dit erin moet
