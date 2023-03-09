package skypro.homeworks.course2.homework03;

public class ServiceStation {
    public void check(Vehicle vehicle) {
        System.out.println("Обслуживаем " + vehicle.getModelName());

        for (int i = 0; i < vehicle.getWheelsCount(); i++) {
            vehicle.updateTyre();
        }

        if (vehicle.getClass() == Car.class) {
            ((Car) vehicle).checkEngine();
        } else if (vehicle.getClass() == Truck.class) {
            ((Truck) vehicle).checkEngine();
            ((Truck) vehicle).checkTrailer();
        }
    }
}
