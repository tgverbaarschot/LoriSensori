// ---------------------------------------- Uplink berichten ----------------------------------------//
#include "Uplink.h"
#include "Sensoren.h"

// ---------------------------------------- Struct instantiëren ----------------------------------------//
TankUl alive;
ATankUl tankenAlarm;
ADieselniveauUl verlagingDieselniveauAlarm;
AAccuniveauUl accuniveauAlarm;
WSlotstandUl slotstandWijziging;
WDieselniveauUl alarmniveauDieselWijziging;
BerichtPointerLengte berichtPointerLengte;
CheckBericht checkBericht;

// ---------------------------------------- Opstellen tankbericht ----------------------------------------//
uint8_t Uplink::berichtTankUl(TankUl *p) 
{
p->ulId = ulIdTankUl;
p->dieselniveau = sensoren.dieselniveaumeting();
p->slotstand = sensoren.slotstandmeting();
p->accuspanning = sensoren.accuniveaumeting();
p->zonnepaneel = sensoren.vermogenZonnepaneelmeting();
p->latGraden = fix.latitudeDMS.degrees;
p->latMinuten = fix.latitudeDMS.minutes;
p->latSeconden = fix.latitudeDMS.seconds_whole;
p->latTiendeSeconden = highByte(fix.latitudeDMS.seconds_frac);
p->lonGraden = fix.longitudeDMS.degrees;
p->lonMinuten = fix.longitudeDMS.minutes;
p->lonSeconden = fix.longitudeDMS.seconds_whole;
p->lonTiendeSeconden = highByte(fix.longitudeDMS.seconds_frac);
p->berichtLengte = 13;
return p;
}


// ---------------------------------------- Opstellen alarm bij te laag dieselniveau ----------------------------------------//
uint8_t Uplink::berichtATankUl(ATankUl *p) 
{
p->ulId = ulIdATankenUl;
p->dieselniveau = sensoren.dieselniveaumeting();
p->berichtLengte = 2;
return p;
}


// ---------------------------------------- Opstellen alarm bij dieselniveauverlaging buiten openingstijd ----------------------------------------//
uint8_t Uplink::berichtADieselniveauUl(ADieselniveauUl *p) 
{
p->ulId = ulIdADieselniveauUl;
p->dieselniveau = sensoren.dieselniveaumeting();
p->slotstand = sensoren.slotstandmeting();
p->latGraden = fix.latitudeDMS.degrees;
p->latMinuten = fix.latitudeDMS.minutes;
p->latSeconden = fix.latitudeDMS.seconds_whole;
p->latTiendeSeconden = highByte(fix.latitudeDMS.seconds_frac);
p->lonGraden = fix.longitudeDMS.degrees;
p->lonMinuten = fix.longitudeDMS.minutes;
p->lonSeconden = fix.longitudeDMS.seconds_whole;
p->lonTiendeSeconden = highByte(fix.longitudeDMS.seconds_frac);
p->berichtLengte = 11;
return p;
}


// ---------------------------------------- Opstellen alarm bij een te laag accuniveau ----------------------------------------//
uint8_t Uplink::berichtAAccuniveauUl(AAccuniveauUl *p) 
{
p->ulId = ulIdAAccuniveauUl;
p->accuspanning = sensoren.accuniveaumeting();
p->berichtLengte = 2;
return p;
}

// ---------------------------------------- Opstellen alarm bij een wijziging van de slotstand ----------------------------------------//
uint8_t Uplink::berichtWSlotstandUl(WSlotstandUl *p) 
{
p->ulId = ulIdWSlotstandUl;
p->slotstand = sensoren.slotstandmeting();
p->berichtLengte = 2;
return p;
}


// ---------------------------------------- Opstellen melding bij wijziging van de melding dieselalarmniveau ----------------------------------------//
uint8_t Uplink::berichtWDieselniveauUl(WDieselniveauUl *p) 
{
p->ulId = ulIdWDieselniveauUl;
p->dieselniveau = alarmniveauDiesel;
p->berichtLengte = 2;
return p;
}



// ---------------------------------------- Opstellen melding Checkbericht ----------------------------------------//
void Uplink::BerichtCheck(CheckBericht *p)
{
    p->ulId = ulIdCheck;                  // uid checkbericht
    p->berichtLengte = 1;                 // lengte van het bericht
}



// ---------------------------------------- Kies bericht n.a.v. tankmetingen ----------------------------------------//
// logica klopt nog niet: ook verschillende berichten achter elkaar versturen?
/*
int Uplink::kiesBericht()
{
  if (sensoren.accuniveaumeting() <25)
  {
    berichtAAccuniveauUl (&accuniveauAlarm);
    return &accuniveauAlarm;
  }
  else if(sensoren.dieselalarmNiveau() == 01)
  {
    berichtATankUl(&tankenAlarm);
    return &tankenAlarm;
  }
  else if (sensoren.slotstandmeting() == 00 && sensoren.dieselniveaumeting())// < tempDieselniveau) // tijdelijke variabele maken met vorig dieselniveau
  {
    berichtADieselniveauUl (&verlagingDieselniveauAlarm);
    return &verlagingDieselniveauAlarm;
  }
  else if (sensoren.slotstandmeting() == 00 ) // alleen als de slotstand is veranderd dus ook tijdelijke variabele
  {
    berichtWSlotstandUl (&slotstandWijziging);
    return &slotstandWijziging;
  }
  else if (1<2 )     // van downlink wijziging dieselniveau ingesteld
  {
    // return ; // 
  }
  else 
  {
      return &ulIdCheck;
  }
}*/

// test 
void Uplink::kiesBericht()   //bekijkt welk bericht/status tank
{
  if (sensoren.dieselalarmNiveau() == 01) // als klasse meegeven, parameter
  {
    berichtATankUl(&tankenAlarm);
    berichtPointerLengte.berichtLengte = tankenAlarm.berichtLengte;
    berichtPointerLengte.berichtPointer = (uint8_t*)&tankenAlarm;
  }
  else
  {
    BerichtCheck(&checkBericht);
    berichtPointerLengte.berichtLengte = checkBericht.berichtLengte;
    berichtPointerLengte.berichtPointer = (uint8_t*)&checkBericht;
  }
}

/*
 * de lengte meesturen heeft wel geholpen nu komen er berichten van de juizte lengte binnen.  maar hoe krijg ik de juiste informatie in het bericht.
 * als ik een pointer meegeef moet die pointer toch ook een type hebben. maar ik weet van tevoren nog niet welk type er verstuurd word.
 * als ik de struct verander in een array van bytes zie ik wel mogenlijkheden maar met de structs kom ik er niet uit.
 */

/*
 * loop maken om onderdelem uit de struct in een array te zetten.
 * of iets maken met malloc?
 */

























/*static void Uplink::kiesBericht (byte ulId)
{
  byte* p = 0;
  memset(&LoraBericht[0], 0, sizeof(LoraBericht));
  switch (ulId)
  {
    case ulIdTankUl : break;
    case ulIdATankenUl : break;
    case ulIdADieselniveauUl : break;
    case ulIdAAccuniveauUlu : break;
    case ulIdWSlotstandUl : break;
    case ulIdWDieselniveauUl : break;
  }
}*/
