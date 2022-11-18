import RPi.GPIO as GPIO
import time

GPIO.setmode(GPIO.BOARD)
GPIO.setup(5, GPIO.OUT)

while true:
    GPIO.output(5, true)
    print("Running")
    time.sleep(1)
    GPIO.output(5, false)
    time.sleep(1)
