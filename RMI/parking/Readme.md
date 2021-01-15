Napisati RMI kod koji implementira udaljeni pristup serveru za parking servis.
* Implementirati klasu `ParkingTicket` sa atributima (string reg - registracija vozila, int zone - zona parkinga, int hour - sat, int minute - minut pocetka parking zahteva)
* Implementirati klasu `ParkingManager` koja ce da sadrzi niz parking zahteva (koristiti HashMap strukturu) i implementirati sledece metode:
	*  `ParkingTicket requestParkingTicket(string reg, int zone, int hour, int minute)` koja kreira novi zahtev za parking i vraca `ParkingTicket`  samo ukoliko vozilo trenutno nema validan zahtev za parking dok u protivnom vraca `null`. (Napomena, zahtev je validan ako nije istekao i traje sat vremena)
	*  `ParkingTicket extendParkingTicket(ParkingTicket ticket, int hour, int minute)` koja ce da izvrsi azuriranje (produzavanje) postojeceg zahteva za parking ukoliko je proslo najmanje 1h a najvise 1h i 15min od pocetka trajanja poslednjeg zahteva.

Implementirati minimalni kod serverske klase `ParkingServer` koja kreira instancu `ParkingManager` objekta i upisuje ga u RMI registar kao i klijentske klase `ParkingClient` u okviru koje ce se za odgovarajuce vozilo kreirati parking zahtev a zatim izvrsiti produzavanje zahteva nakoj 1h i 10min.

*[sept 2018.]*