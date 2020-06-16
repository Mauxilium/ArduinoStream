/**
 * 
 */
 #include <ArduinoSerialRpc.h>

ArduinoSerialRpc rpc("Float Stream Test Sketch (www.mauxilium.it)");
float streamCounter = 0.0;

void setup() {
  Serial.begin(9600);
 }

void serialEvent() {
  rpc.serialEventHandler();
}

void loop() {
  delay(100);
  streamCounter += 0.1;
  rpc.executeRemoteMethod("stream", streamCounter);
}
