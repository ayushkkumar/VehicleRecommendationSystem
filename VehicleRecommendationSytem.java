import java.util.*;

class Vehicle {
    private final int locationId;
    private final String vehicleNo;
    private final String VehicleCategory;
    private final int passengerCapacity;
    private final boolean Available;
    private final String driverContactNo;

    // Constructor
    public Vehicle(int locationId, String vehicleNo, String VehicleCategory, int passengerCapacity,
                   boolean Available, String driverContactNo) {
        this.locationId = locationId;
        this.vehicleNo = vehicleNo;
        this.VehicleCategory = VehicleCategory;
        this.passengerCapacity = passengerCapacity;
        this.Available = Available;
        this.driverContactNo = driverContactNo;
    }

    // Getters and setters
    public int getLocationId() {
        return locationId;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public String getVehicleCategory() {
        return VehicleCategory;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public boolean isAvailable() {
        return Available;
    }

    public String getDriverContactNo() {
        return driverContactNo;
    }
}

public class VehicleRecommendationSystem {
    private final List<Vehicle> vehicleList;

    // Constructor to initialize the list of vehicles
    public VehicleRecommendationSystem(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    // Method to recommend vehicles based on their location ID and passenger count
    public List<Vehicle> recommendVehicles(int yourLocationId, int numOfPassengers) {
        List<Vehicle> availableVehicles = filterAvailableVehicles(numOfPassengers);

        // Sort available vehicles based on Euclidean distance from your location
        availableVehicles.sort(Comparator.comparingInt(v -> calculateDistance(v.getLocationId(), yourLocationId)));

        // Return the three nearest available vehicles (or all available if less than three)
        return availableVehicles.subList(0, availableVehicles.size());
    }

    // Calculate the Euclidean distance between two locations
    private int calculateDistance(int locationId1, int locationId2) {
        return (locationId1 - locationId2) * (locationId1 - locationId2);
    }

    // Filter available vehicles with sufficient passenger capacity
    private List<Vehicle> filterAvailableVehicles(int numOfPassengers) {
        List<Vehicle> availableVehicles = new ArrayList<>();
        for (Vehicle vehicle : vehicleList) {
            if (vehicle.isAvailable() && vehicle.getPassengerCapacity() >= numOfPassengers) {
                availableVehicles.add(vehicle);
            }
        }
        return availableVehicles;
    }

    // Test the recommendation system
    public static void main(String[] args) {
        // Sample data for vehicles
        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(new Vehicle(100, "HR-26 0091", "car", 4, true, "090909878"));
        vehicleList.add(new Vehicle(201, "HR-26 7896", "auto", 2, true, "09876534"));
        vehicleList.add(new Vehicle(301, "HR-26 2345", "car", 5, true, "78902564"));
        vehicleList.add(new Vehicle(11, "HR-26 8798", "car", 4, false, "987654"));
        vehicleList.add(new Vehicle(101, "HR-26 6754", "auto", 2, false, "78990245"));
        vehicleList.add(new Vehicle(110, "HR-26 7891", "bike", 1, true, "87902453"));
        vehicleList.add(new Vehicle(102, "HR-26 5678", "bike", 1, false, "78902453"));

        VehicleRecommendationSystem recommendationSystem = new VehicleRecommendationSystem(vehicleList);

        Scanner sc=new Scanner(System.in);
        System.out.print("Enter your Location ID: ");
        int yourLocationId = sc.nextInt();
        System.out.print("Enter the no. of seats required: ");
        int numOfPassengers = sc.nextInt();

        List<Vehicle> recommendedVehicles = recommendationSystem.recommendVehicles(yourLocationId, numOfPassengers);


        // Printing the recommended vehicles
        System.out.println("List of recommended vehicles:");
        if(recommendedVehicles.size()==0){
            // If no vehicles are found as per the user's needs
            System.out.println("Sorry for the inconvenience, no vehicles found");
        }
        // Checking for car
        for (Vehicle vehicle : recommendedVehicles){
            if(Objects.equals(vehicle.getVehicleCategory(), "car")){
                System.out.println(vehicle.getVehicleNo() + "," + vehicle.getVehicleCategory() +
                        "," + vehicle.getDriverContactNo());
                break;
            }
        }
        // Checking for auto
        for (Vehicle vehicle : recommendedVehicles){
            if(Objects.equals(vehicle.getVehicleCategory(), "auto")){
                System.out.println(vehicle.getVehicleNo() + "," + vehicle.getVehicleCategory() +
                        "," + vehicle.getDriverContactNo());
                break;
            }
        }
        // Checking for bike
        for (Vehicle vehicle : recommendedVehicles){
            if(Objects.equals(vehicle.getVehicleCategory(), "bike")){
                System.out.println(vehicle.getVehicleNo() + "," + vehicle.getVehicleCategory() +
                        "," + vehicle.getDriverContactNo());
                break;
            }
        }
    }
}
