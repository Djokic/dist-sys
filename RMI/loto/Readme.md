Napisati RMI kod koji implementira udaljeni pristup serveru za igranje Loto igre na srecu (7 od 39)
* Implementirati klasu `Ticket` sa atributima (int id - jedinstveni id, Vector numbers - niz brojeva koje igra korisnik)
* Implementiratio klasu `LotoManager` sa sledecim metodama:
	* `Ticket playTicket(Vector numbers)` koja ce da registruje tiket u sistemu i dodeliti mu jedinstveni id. Ukoliko se ova funkcija pozove nakon sto je izvrseno izvlacenje potrebno je vratiti `null`
	* `Vector getWinners()` koja ce da vrati niz ide-jeva za tikete koji imaju najvise pogodjenih brojeva.
	* `void drawNumbers()` koja vrsi izvlacenje 7 od mogucih 39 brojeva. (Za izvlacenje slucajnih borjeva koristitu f-ju Math.random() koja vraca realne brojeve u opsegu 0.0 - 1.0)

Implementirati minimalni kod serverske klase `LotoServer` koja kreira instancu `LotoManager` objekta i upisuje ga u RMI registar kao i klijentske klase `LotoClient` u okviru koje ce se izvrsiti igranje jedne kombinacije brojeva.

*[mart 2019.]*