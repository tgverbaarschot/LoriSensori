#ifndef Actuatoren_h
#define Actuatoren_h

#include <arduino.h>
#include <Time.h>
#include <TimeAlarms.h>

// ---------------------------------------- Class actuatoren ----------------------------------------//



  
class Actuatoren
{
  public:
  Actuatoren();
  void SETUP();
  void instellenOpeningstijd(int uurOpen, int minutenOpen, void (*openSlotPntr)());
  void instellenSluitingstijd(int uurDicht, int minutenDicht, void (*sluitSlotPntr)());
  static void openSlot();
  static void sluitSlot();



};


extern Actuatoren actuatoren;

#endif //Actuatoren.h
