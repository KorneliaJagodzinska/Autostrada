import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Highway {

    Map<String, VehicleInfo> mapaPojazdów = new HashMap<>();

    public void vehicleEntry(String nrRejestracyjny, CarType carType) {
        VehicleInfo nowyPojazd = new VehicleInfo(nrRejestracyjny, carType, LocalDateTime.now());
        mapaPojazdów.put(nrRejestracyjny, nowyPojazd);
        System.out.println("Na autostradę wjechał pojazd o numerze rejstracyjnym: " + nrRejestracyjny);
    }

    public VehicleInfo searchVehicle(String nrRejestracyjny) {
        if (mapaPojazdów.containsKey(nrRejestracyjny)) {
            System.out.println("Pojazd wciąż znajduje się na autostradzie.");
            return mapaPojazdów.get(nrRejestracyjny);
        }
        throw new NieMoznaZnalezcPojazduException();

    }

    public void vehicleLeave(String nrRejestracyjny) {
        if (!mapaPojazdów.containsKey(nrRejestracyjny)) {
            throw new NieMoznaZnalezcPojazduException();
        }
        System.out.println("Pojazd " + mapaPojazdów.get(nrRejestracyjny) + " opuścił autostradę");
        obliczKwoteZapłatyZaPrzejazd(nrRejestracyjny);
        removeVehicle(nrRejestracyjny);
    }

    private void removeVehicle(String nrRejestracyjny) {
        mapaPojazdów.remove(nrRejestracyjny);
        System.out.println("Pojazd o numerze rejestracyjnym: " + nrRejestracyjny + " opuścił autostradę");
    }

    private double obliczKwoteZapłatyZaPrzejazd(String nrRejestracyjny) {

        Duration długośćPrzejazdu = Duration.between(mapaPojazdów.get(nrRejestracyjny).getDataWjazduNaAutostrade(), LocalDateTime.now());

        double doZapłaty = 0.0;
        // obliczamy kwotę do zapłaty w zależności od typu pojazdu
        switch (mapaPojazdów.get(nrRejestracyjny).getCarType()) {
            case CAR:
                doZapłaty = długośćPrzejazdu.getSeconds() * 0.3;
                break;
            case MOTORCYCLE:
                doZapłaty = długośćPrzejazdu.getSeconds() * 0.2;
                break;
            case TRUCK:
                doZapłaty = długośćPrzejazdu.getSeconds() * 0.5;
                break;
        }
        System.out.println("Do zapłaty: " + doZapłaty);
        return doZapłaty;
    }

}

