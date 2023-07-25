# VehicleRecommendationSystem
## Recommends vehicles on the basis of Euclidean distance between User location and Vehicle location

### The program is built on Java Programming Language using basic concepts of Object Oriented Programming.

#### Q1. First design a data structure that stores all the information about the vehicle. Like: location id(unique), vehicle no, vehicle category, no of passengers allowed, vehicle occupied or available, driver contact no.
Ans1. The Vehicle class is used as the data structure for storing all the information about the vehicle

#### Q2. A method where you put your information based on that output will print 3 types of vehicle details.
Ans2. In this code, this functionality is programmed inside the `recommendVehicles()` function. A working code is attached in the file VehicleRecommendationSystem.java

### Working of the program
1. A Java list (`vehicleList`) is used to store all the vehicle details as separate objects based on the Vehicle class.
2. The user inputs their location and the no. of seats required for them.
3. A new list (`recommendedVehicles`) is used to store all the available vehicles that meet the minimum seats required criterion, that too in the order of the Euclidean distance between user location and car location ID.
4. The `recommendVehicles()` method works by first creating a list (`availableVehicles`) of the vehicles meeting the specified criterion using the `filterAvailableVehicles()`. The `availableVehicles` list is then sorted based on the Euclidean distance between the user location and vehicle location ID, which is calculated using the `calculateDistance()` method.
5. The output from the `recommendVehicles()` method is then used to output the available car, auto, and bike. By finding their first occurrence in the `recommendedVehicles` list.
