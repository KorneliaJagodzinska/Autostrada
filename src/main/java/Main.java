import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Highway highway = new Highway();

        String komenda;
        do {
            System.out.println("Podaj komendę składającą się z trzech parametrów:\n " +
                            "1.wjazd, wyjazd,sprawdz \n 2.nr Rejestracyjny \n 3.Typ pojazdu: CAR, MOTORCYCLE, TRUCK");
            komenda = scanner.nextLine();

            String[] słowa = komenda.split(" ");

            if (słowa[0].equalsIgnoreCase("wjazd")) {
                if (słowa.length >= 3) {
                    String nrRej = słowa[1];
                    String slowoTypPojazdu = słowa[2];

                    try {
                        if (highway.searchVehicle(nrRej) != null) {
                            System.err.println("Taki pojazd juz wjechal, drugi taki sam nie moze!");
                        }
                    } catch (NieMoznaZnalezcPojazduException e) {
                        try {
                            CarType typ = CarType.valueOf(slowoTypPojazdu.toUpperCase());
                            highway.vehicleEntry(nrRej, typ);
                        } catch (IllegalArgumentException iae) {
                            System.err.println("Błąd, zły typ pojazdu.");
                        }
                    }
                }
            } else if (słowa[0].equalsIgnoreCase("wyjazd")) {
                if (słowa.length >= 2) {
                    String nrRej = słowa[1];

                    highway.vehicleLeave(nrRej);
                }
            } else if (słowa[0].equalsIgnoreCase("sprawdz")) {
                if (słowa.length >= 2) {
                    String nrRej = słowa[1];

                    highway.searchVehicle(nrRej);

                }
            }

        } while (!komenda.equalsIgnoreCase("zamknij"));
    }
}
