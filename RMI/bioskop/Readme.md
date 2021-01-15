Napisati RMI kod koji implementira pristup serveru za rezervaciju mesta u bioskopu.
* Implementirati klasu `ReservationManager` koja ce da sadrzi internu strukturu u obliku matrice (m x n,  m redova sa po n sedista) objekta `Seat` kao i listu objekata `Reservation` koja pamti trenutno aktivne rezervacije
* Implementirati minimalni kod serverske klase `ReservationServer` koja kreira instancu klase `ReservationManager` i upisuje ga u RMI registar kao i klijentske klase `ReservationClient` koja preuzima interfejs klase `ReservationManager` iz RMI registra
	* Implementirati klasu `Seat` koja sadrzi informaciju o broju (int seatNum) i redu sedista (int seatRow) kao i flag (boolean isFree) koji oznacava da li je sediste slobodno
	* Implementirati klasu `Reservation` koja treba da sadrzi id rezervacije, poziciju prvog sedista u nizu (int seatRow, int seatNum) kao i broj uzastopnih sedista (int numSeats)
* U okviru klase `ReservationManager` implementirati sledece metode
	*  `Reservation makeReservation(int seatRow, int seatNum, int numSeats)` koja rezervize niz od (numSeats) uzastopnih sedista pocev od sedista na poziciji (seatRow, seatNum), postavlja flag isFree odgovarajucih sedista na false i vraca objekat tipa `Reservation`. Ukoliko nije moguce rezervisati sedista metod treba da vrati `null`.
	*  `cancelReservation(int id)` koja brise rezervaciju i oslobadja odgovarajuca sedista.

  *[I kol - 2018.]*