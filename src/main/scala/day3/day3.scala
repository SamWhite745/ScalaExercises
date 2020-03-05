package day3

import scala.collection.mutable.ListBuffer

object day3 extends App {
//  def functional1() = {
//    java.util.TimeZone.getAvailableIDs().foreach(el => el.fil)
//  }

  abstract class Person {
    def name: String
  }

  abstract class Vehicle {
    def numberOfWheels: Int
    def cost: Int
    def model: String
    def customer: Customer
    override def toString: String = s"$model has $numberOfWheels and costs $cost"
  }

  class Bike(customerInput: Customer) extends Vehicle {
    def numberOfWheels: Int = 2
    def cost: Int = 100
    def model: String = "Bike"
    def customer: Customer = customerInput
  }

  class Car(customerInput: Customer) extends Vehicle {
    def numberOfWheels: Int = 4
    def cost: Int = 250
    def model: String = "Car"
    def customer: Customer = customerInput

  }

  class Customer(CustomerName: String, vehicleList: ListBuffer[Vehicle]) extends Person {
    def name: String = CustomerName
    def vehicles: ListBuffer[Vehicle] = vehicleList
    def addVehicle(vehicle: Vehicle): Unit = vehicles+=vehicle
  }

  class Employee(employeeName:String, employeeID:Int) extends Person {
    def name: String = employeeName
    def ID: Int = employeeID
  }


}
