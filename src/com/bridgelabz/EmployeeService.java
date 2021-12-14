package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeService {

    public enum IOService {
        CONSOLE_IO, FILE_IO, DB_IO, REST_IO
    }

    public static final Scanner SC = new Scanner(System.in);
    private List<EmployeeData> employeeList;

    public EmployeeService() {
        this.employeeList = new ArrayList<EmployeeData>();
    }

    public EmployeeService(List<EmployeeData> employeeList) {
        this.employeeList = employeeList;
    }

    public int sizeOfEmployeeList() {
        return this.employeeList.size();
    }

    public void readEmployeeData(IOService ioType) {
        if (ioType.equals(IOService.CONSOLE_IO)) {
            System.out.println("Enter employee id:");
            int employeeId = SC.nextInt();
            System.out.println("Enter employee name:");
            SC.nextLine();
            String employeeName = SC.nextLine();
            System.out.println("Enter employee salary:");
            double employeeSalary = SC.nextDouble();
            EmployeeData newEmployee = new EmployeeData(employeeId, employeeName, employeeSalary);
            employeeList.add(newEmployee);
        } else if (ioType.equals(IOService.FILE_IO)) {
            this.employeeList = new EmployeeFileIOService().readData();
        }
    }

    public void writeEmployeeDdate(IOService ioType) {
        if (ioType.equals(IOService.CONSOLE_IO)) {
            for (EmployeeData o : employeeList)
                System.out.println(o.toString());
        } else if (ioType.equals(IOService.FILE_IO)) {
            new EmployeeFileIOService().writeData(employeeList);
        }
    }

    public long countEnteries(IOService ioType) {
        if (ioType.equals(IOService.FILE_IO))
            return new EmployeeFileIOService().countEntries();
        return 0;
    }

    public void printEmployeePayrollData() {
        new EmployeeFileIOService().printEmployeePayrolls();
    }

}