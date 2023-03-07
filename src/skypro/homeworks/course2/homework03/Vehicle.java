package skypro.homeworks.course2.homework03;

public abstract class Vehicle implements Serviceable {
    private String modelName;
    private int wheelsCount;

    public Vehicle(String modelName, int wheelsCount) {
        this.modelName = modelName;
        this.wheelsCount = wheelsCount;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getWheelsCount() {
        return wheelsCount;
    }

    public void setWheelsCount(int wheelsCount) {
        this.wheelsCount = wheelsCount;
    }

    @Override
    public void updateTyre(Vehicle vehicle) {
        System.out.println("Меняем покрышку у " + vehicle.getModelName());
    }

    @Override
    public void checkEngine(Car car) {
        System.out.println("Проверяем двигатель у " + car.getModelName());
    }

    @Override
    public void checkEngine(Truck truck) {
        System.out.println("Проверяем двигатель у " + truck.getModelName());
    }

    @Override
    public void checkTrailer(Truck truck) {
        System.out.println("Проверяем прицеп у " + truck.getModelName());
    }
}
