/**
 * 
 */
 #include <ArduinoSerialRpc.h>

ArduinoSerialRpc rpc("String Stream Test Sketch (www.mauxilium.it)");
int streamCounter = 0;

void setup() {
  Serial.begin(9600);
 }

void serialEvent() {
  rpc.serialEventHandler();
}

void loop() {
  // delay(1000);
  rpc.executeRemoteMethod("stream", "c="+String(streamCounter++));
}
