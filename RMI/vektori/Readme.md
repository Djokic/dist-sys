Napisati RMI kod koji implementira udaljeni pristup server za izracunavanje oparacija nad vektorima (u ovom slucaju skalarni proizvod vektora).
* Implementirati klasu `VCalcRequest` sa atributima (int cId - jedinstveni identifikator izracunavanja, Vector a - prvi vektor predstavljen kao niz realnih brojeva, Vector b - drugi vektor, VCalcCallback cb - callback interfejs)
* Imlementirati klasu `VCalcManager` koja ce da sadrzi sledece metode
	* `int SendVCalcRequest(VCalcRequest req)` - koja preuzima zahtev za izracunavanjem i stavlja ga u red na cekanju, pro tome se generise i vraca jedinstveni identifikator trenutnog izracunavanja.
	* `bool RunNextVCalc()` - koja preuzima prvi zahtev iz reda cekanja, izvrsava operaciju skalarnog proizvoda nad vektorima i poziva odgovarajucu callback metodu i vraca true. Definisati `VCalcCallback` interfejs koji ce da sadrzi metodu `onDone(int cId -identifikator izracunavanja, double result - rezultat izracunavanja)` koja ce biti pozvana nakon zavrsetka izracunavanja.

Implementirati serverske kalse `VCalcServer` koja kreira instancu `VCalcManager` objekta i upisuje ga u RMI registar kao i klijentske klase `VCalcClient` u okviru koje ce se poslati zahtev za izracunavanjem skalarnog proizvoda.

*[sept 2020]*