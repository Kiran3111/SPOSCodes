#include "DFRobot_DHT11.h"
#define dht_apin A0

DFRobot_DHT11 DHT;

void setup(){
    Serial.begin(9600);
    delay(500);
    Serial.println("DHT11 Humidity & temperature Sensor\n\n");
    delay(1000);
}

void loop(){
    DHT.read(dht_apin);
    Serial.print("Current humidity = ");
    Serial.print(DHT.humidity);
    Serial.print("% ");
    Serial.print("temperature = ");
    Serial.print(DHT.temperature);
    Serial.println("C ");
    delay(5000);
}
