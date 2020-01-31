import java.time.LocalDateTime;

public class VehicleInfo {
    private String nrRejestracyjny;
    private CarType carType;
    private LocalDateTime dataWjazduNaAutostrade;

    public VehicleInfo(String nrRejestracyjny, CarType carType, LocalDateTime dataWjazduNaAutostrade) {
        this.nrRejestracyjny = nrRejestracyjny;
        this.carType = carType;
        this.dataWjazduNaAutostrade = dataWjazduNaAutostrade;
    }

    public String getNrRejestracyjny() {
        return nrRejestracyjny;
    }

    public CarType getCarType() {
        return carType;
    }

    public LocalDateTime getDataWjazduNaAutostrade() {
        return dataWjazduNaAutostrade;
    }

    @Override
    public String toString() {
        return "VehicleInfo{" +
                "nrRejestracyjny='" + nrRejestracyjny + '\'' +
                ", carType=" + carType +
                ", dataWjazduNaAutostrade=" + dataWjazduNaAutostrade +
                '}';
    }
}
