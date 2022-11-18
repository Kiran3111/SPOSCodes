int IrSensor=12;
int LED=7;
int buzzer=8;

void setup() {
    pinMode(IrSensor, INPUT);
    pinMode(LED, OUTPUT);
    pinMode(buzzer, OUTPUT);
}

void loop(){
    
    int status=digitalRead(IrSensor);
    if(status==1)
    {
        digitalWrite(LED, LOW);
        digitalWrite(buzzer, LOW)
    }
    else {
        digitalWrite(LED, HIGH);
        digitalWrite(buzzer, HIGH);
    }
}
