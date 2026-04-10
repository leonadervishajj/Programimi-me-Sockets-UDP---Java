**Programimi me Sockets (UDP) - Java**

Ky projekt demonstron komunikimin në rrjet duke përdorur UDP(User Datagram Protocol) në gjuhën programuese Java. 
Qëllimi është të implementohet një sistem i thjeshtë Client - Server, ku klienti dërgon mesazh dhe serveri kthen përgjigje.

***🌐 Çka është UDP?***

  UDP është një protokoll komuninikimi në rrjet që : 
  - nuk kërkon lidhje paraprake(connections),
  - nuk garanton dorëzimin e paketave
  - është më i shpejtë se TCP

Përdoret zakonisht në aplikacioni si *streaming*,*gaming*, dhe *komunikim* real-time. 

***Funksionalitete e Serverit***

- Pranon mesazhe nga shumë klientë përmes UDP
- Identifikon klientët përmes IP dhe portit
- Menaxhon kërkesat e klientëve
- Ruaj mesazhet për monitorim
- Simulon "lidhje" duke mbajtur listë të klientëve aktivë
- Mbyll klientët joaktivë pas një kohe të caktuar
- Lejon rikthimin e klientëve
- Ofron qasje në file për klientët admin


