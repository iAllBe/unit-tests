import Model.Car;
import Model.Motorcycle;
import Model.Vehicle;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class VehicleTest {

    // Методы для создания объектов с заданными параметрами
    private Car createCar() {
        return new Car("Toyota", "Camry", 2022);
    }

    private Motorcycle createMotorcycle() {
        return new Motorcycle("Honda", "CBR", 2022);
    }


    // Проверка того, что экземпляр объекта Car также является экземпляром транспортного средства (Vehicle)
    @Test
    public void testCarIsInstanceOfVehicle() {
        assertThat(createCar()).isInstanceOf(Vehicle.class);
    }

    // Проверка того, что объект Car создается с 4-мя колесами
    @Test
    public void testCarHasFourWheels() {
        assertThat(createCar().getNumWheels()).isEqualTo(4);
    }

    // Проверка того, что объект Motorcycle создается с 2-мя колесами
    @Test
    public void testMotorcycleHasTwoWheels() {
        assertThat(createMotorcycle().getNumWheels()).isEqualTo(2);
    }

    // Проверка того, что объект Car развивает скорость 60 в режиме тестового вождения (testDrive())
    @Test
    public void testCarSpeedDuringTestDrive() {
        Car car = createCar();
        car.testDrive();
        assertThat(car.getSpeed()).isEqualTo(60);
    }

    // Проверка того, что объект Motorcycle развивает скорость 75 в режиме тестового вождения (testDrive())
    @Test
    public void testMotorcycleSpeedDuringTestDrive() {
        Motorcycle motorcycle = createMotorcycle();
        motorcycle.testDrive();
        assertThat(motorcycle.getSpeed()).isEqualTo(75);
    }

    // Проверка того, что объект Car останавливается при парковке (speed = 0)
    @Test
    public void testCarStopsWhenParked() {
        Car car = createCar();
        car.testDrive();
        car.park();
        assertThat(car.getSpeed()).isZero();
    }

    // Проверка того, что объект Motorcycle останавливается при парковке (speed = 0)
    @Test
    public void testMotorcycleStopsWhenParked() {
        Motorcycle motorcycle = createMotorcycle();
        motorcycle.testDrive();
        motorcycle.park();
        assertThat(motorcycle.getSpeed()).isZero();
    }
}