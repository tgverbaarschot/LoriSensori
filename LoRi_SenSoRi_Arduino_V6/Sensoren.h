#ifndef Sensoren_h
#define Sensoren_h

#include <arduino.h>
#include <NMEAGPS.h>
#include <GPSport.h>
#include <DMS.h>


// ---------------------------------------- Class sensoren ----------------------------------------//
class Sensoren
{
  public:
  Sensoren();
  void SETUP();
  static byte accuniveaumeting();
  byte accuAlarm(byte accuniveau);
  byte dieselniveaumeting();
  byte alarmNiveauInstellen(byte downlinkDieselniveau);
  byte dieselalarmNiveau();
  byte vermogenZonnepaneelmeting();
  byte slotstandmeting();
  void GPSmeting();
};

extern int alarmniveauDiesel;
extern NMEAGPS gps;                    // This parses the GPS characters
extern gps_fix fix;                    // This holds on to the latest values
extern Sensoren sensoren;

#endif //Sensoren.h
