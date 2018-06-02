import java.util.*;

public class CallCenter {
    enum EmployeeLevel {
        Respndant, Manager, Director;
    }

    private static class Employee implements Comparable<Employee> {
        private EmployeeLevel level;
        private int id;
        private boolean free;

        public Employee(EmployeeLevel level, int id, boolean free) {
            this.level = level;
            this.id = id;
            this.free = free;
        }

/*        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Employee employee = (Employee) o;
            return id == employee.id &&
                    free == employee.free &&
                    level == employee.level;
        }

        @Override
        public int hashCode() {
            return Objects.hash(level, id, free);
        }*/

        @Override
        public int compareTo(Employee o) {
            return (this.free && !o.free) ? -1 : (!this.free && o.free) ? 1 : (this.level != o.level) ? this.level.ordinal() - o.level.ordinal() : this.id - o.id;
        }

        @Override
        public String toString() {
            return "[" + id + ", " + free + ", " + level + "]";
        }
    }

    public static void main(String[] args) {
        SortedSet<Employee> employees = new TreeSet<>();
        Map<Integer, Employee> map = new HashMap<>();
        int emplId = 0;
        Employee emp = new Employee(EmployeeLevel.Respndant, emplId++, true);
        map.put(emp.id, emp);
        employees.add(emp);
        emp = new Employee(EmployeeLevel.Manager, emplId++, true);
        map.put(emp.id, emp);
        employees.add(emp);
        emp = new Employee(EmployeeLevel.Director, emplId++, false);
        map.put(emp.id, emp);
        employees.add(emp);
        emp = new Employee(EmployeeLevel.Respndant, emplId++, true);
        map.put(emp.id, emp);
        employees.add(emp);
        emp = new Employee(EmployeeLevel.Respndant, emplId++, true);
        map.put(emp.id, emp);
        employees.add(emp);
        emp = new Employee(EmployeeLevel.Manager, emplId++, false);
        map.put(emp.id, emp);
        employees.add(emp);
        emp = new Employee(EmployeeLevel.Director, emplId++, true);
        map.put(emp.id, emp);
        employees.add(emp);
        emp = new Employee(EmployeeLevel.Respndant, emplId++, false);
        map.put(emp.id, emp);
        employees.add(emp);
        emp = new Employee(EmployeeLevel.Respndant, emplId++, true);
        map.put(emp.id, emp);
        employees.add(emp);
        emp = new Employee(EmployeeLevel.Manager, emplId++, false);
        map.put(emp.id, emp);
        employees.add(emp);
        emp = new Employee(EmployeeLevel.Respndant, emplId++, true);
        map.put(emp.id, emp);
        employees.add(emp);
        emp = new Employee(EmployeeLevel.Respndant, emplId++, true);
        map.put(emp.id, emp);
        employees.add(emp);

        //Collections.sort(employees);
        System.out.println(employees);

        emp = map.get(10);
        employees.remove(emp);
        emp.free = false;
        employees.add(emp);

        //Collections.sort(employees);
        System.out.println(employees);

    }

}
