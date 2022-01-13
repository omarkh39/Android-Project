import socket
ava="Available"
s = socket.socket()       
s2 = socket.socket()
s.bind(('0.0.0.0', 8090 ))
s2.bind(('0.0.0.0', 8099 ))

s.listen(2)  
s2.listen(1)
               

while True:
 
    client, addr = s.accept()
    client2, addr2 = s2.accept()
 
    while True:
        content = client.recv(32)
 
        if len(content) ==0:
           break
 
        else:
            if content.decode()=='ocupied':
                ava="ocupied"
            else:
                ava='Available'

                  
                
            client2.send(ava.encode('Ascii'))    
            
            print(content.decode())
            
 
    
    client.close()
    client2.close()