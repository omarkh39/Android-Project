#include <WiFi.h>


const int trigPin = 2;
const int echoPin = 15;

const int LED1 = 22;
const int LED2 = 23;

int duration = 0;
int distance = 0;
 
const char* ssid = "Zhone_F758";
const char* password =  "znid310942296";
 
const uint16_t port = 8090;
const char * host = "192.168.1.15";
 
void setup()
{
  pinMode(trigPin , OUTPUT);
  pinMode(echoPin , INPUT); 
  
  pinMode(LED1 , OUTPUT);
  pinMode(LED2 , OUTPUT);
  
  Serial.begin(115200);
 
  WiFi.begin(ssid, password);
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.println("...");
  }
 
  Serial.print("WiFi connected with IP: ");
  Serial.println(WiFi.localIP());
 
}
 
void loop()
{
  digitalWrite(trigPin, LOW);
  delayMicroseconds(2);
  digitalWrite(trigPin, HIGH);
  delayMicroseconds(10);
  digitalWrite(trigPin, LOW);  
  duration = pulseIn(echoPin, HIGH);
  distance = duration/58.2;
  
    WiFiClient client;
 
    if (!client.connect(host, port)) {
 
        Serial.println("Connection to host failed");
 
        delay(1000);
        return;
    }
 
    Serial.println("Connected to server successful!");
 
    

    if ( distance < 50 )
  {
    digitalWrite(LED1, HIGH);
    client.print("ocupied");
    
    delay(100);
  }
  else
  {
    digitalWrite(LED1, LOW);
  }
  if ( distance >= 50 )
  {
    digitalWrite(LED2, HIGH);
    client.print("Available");
 
    delay(100);
  }
  else
  {
    digitalWrite(LED2, LOW);
  }

  delay(100);

  
    
 
    Serial.println("Disconnecting...");
    
 
    delay(500);
}
