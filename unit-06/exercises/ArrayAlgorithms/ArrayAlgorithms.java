import java.util.Arrays;

class Student {
    private String name;
    private int age;
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() { return name; }
    public String getLastName() { return name; }
    public int getAge() { return age; }
}

public class ArrayAlgorithms {
    // Sum and average

    public int sum(int[] values) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum;
    }

    public double average(int[] values) {
        return (double)sum(values) / values.length;
    }

    public double sum(double[] values) {
        double sum = 0;
        for (double value : values) {
            sum += value;
        }
        return sum;
    }

    public double average(double[] values) {
        return sum(values) / values.length;
    }

    private Student[] students = {
        new Student("Alice", 16),
        new Student("Bob", 15),
        new Student("Carleton", 17),
        new Student("David", 17)
    };

    public Student findStudentByName(String name) {
        for (Student student : students) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        return null;
    }

    public int indexOfStudentWithLastName(Student[] students, String lastName, int startIndex) {
        for (int i=startIndex, n=students.length; i<n; i++) {
            if (students[i].getLastName().equals(lastName)) {
                return i;
            }
        }
        return -1;
    }

    public int countStudentsWithLastName(Student[] students, String lastName) {
        int count = 0;
        for (Student student : students) {
            if (student.getLastName().equals(lastName)) {
                count++;
            }
        }
        return count;
    }

    public Student[] getStudentsWithLastName(Student[] students, String lastName) {
        Student[] result = new Student[countStudentsWithLastName(students, lastName)];
        int count = 0;
        for (Student student : students) {
            if (student.getLastName().equals(lastName)) {
                result[count++] = student;
            }
        }
        return result;
    }

    public double[] getStudentAges(Student[] students) {
        int count = students.length;
        double[] ages = new double[count];
        for (int i=0; i<count; i++) {
            ages[i] = students[i].getAge();
        }
        return ages;
    }

    public double averageStudentAge(Student[] students) {
        double sum = 0;        
        for (Student student : students) {
            sum += student.getAge();
        }
        return sum / students.length;
    }

    public double averageStudentAge2(Student[] students) {
        return average(getStudentAges(students));
    }

    // Precondition: Array "values" must not be empty and must be sorted
    // in ascending order.
    public double medianOfSortedArray(double[] sortedValues) {
        int length = sortedValues.length;
        int middle = length / 2;
        if (length % 2 == 0) {
            return (sortedValues[middle-1] + sortedValues[middle]) / 2;
        } else {
            return sortedValues[middle];
        }
    }

    // import java.util.Arrays;
    public double[] sortedCopyOfArray(double[] values) {
        double[] sortedValues = Arrays.copyOf(values, values.length);
        Arrays.sort(sortedValues);
        return sortedValues;
    }

    // Precondition: Array "values" must not be empty.
    public double median(double[] values) {
        return medianOfSortedArray(sortedCopyOfArray(values));
    }
    
    public double medianStudentAge(Student[] students) {
        return median(getStudentAges(students));
    }

    public boolean hasDuplicates(double[] values) {
        for (int i=0, n=values.length; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                if (values[i] == values[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public void removeStudentAt(Student[] students, int targetIndex) {
        int n = students.length;
        for (int i=targetIndex; i<n; i++) {
            students[i] = students[i+1];
        }
        students[n-1] = null;
    }

    public void insertStudentAt(Student[] students, Student newStudent, int targetIndex) {
        int n = students.length;
        for (int i=n-1; i>targetIndex; i--) {
            students[i] = students[i-1];
        }
        students[targetIndex] = newStudent;
    }

    // Precondition: Array "values" must not be empty.
    public void rotateLeft(double[] values) {
        double firstValue = values[0];
        for (int i=0, n=values.length; i<n-1; i++) {
            values[i] = values[i+1];
        }
        values[values.length-1] = firstValue;
    }

    public double[] copyRotatedLeft(double[] values, int rotateAmount) {
        int n = values.length;
        double[] result = new double[n];
        for (int i=0; i<n; i++) {
            result[i] = values[(i + rotateAmount) % n];
        }
        return result;
    }

    // Precondition: Array "values" must not be empty
    public void rotateLeftMultiple(double[] values, int rotateAmount) {
        while (rotateAmount > 0) {
            rotateLeft(values);
            rotateAmount--;
        }
    }

    // Precondition: Array "values" must not be empty
    public boolean allEven(int[] values) {
      for (int value : values) {
        if (value % 2 != 0) {
            return false;
        }
      }
      return true;
    }

    public boolean anyOdd(int[] values) {
        for (int value : values) {
            if (value % 2 != 0) {
                return true;
            }
          }
          return false;
    }

    public boolean anyOdd2(int[] values) {
        return !allEven(values);
    }

    // Precondition: Array "values" must not be empty.
    public void rotateRight(double[] values) {
        int n = values.length;
        double lastValue = values[n-1];
        for (int i=n-1; i>0; i--) {
            values[i] = values[i-1];
        }
        values[0] = lastValue;
    }

    // Precondition: "values" must be sorted
    public boolean sortedArrayHasDuplicates(double[] values) {
        for (int i=1, n=values.length; i<n; i++) {
            if (values[i-1] == values[i]) {
                return true;
            }
        }
        return false;    
    }

    // Precondition: Array "values" must not be empty.
    public double mode(double[] values) {
        double modeValue = values[0];
        int modeFrequency = 1;
        for (int i=1, n=values.length; i<n; i++) {
            double value = values[i];
            if (value != modeValue) {
                int frequency = 0;
                for (int j=0; j<n; j++) {
                    if (values[j] == value) {
                        frequency++;
                    }
                }
                if (frequency > modeFrequency) {
                    modeFrequency = frequency;
                    modeValue = value;
                }
            }
        }
        return modeValue;
    }

    // Precondition: Array "values" must not be empty.
    public double mode2(double[] values) {
        double modeValue = Double.NaN;
        int modeFrequency = 0;
        for (double value : values) {
            int frequency = countOccurrences(values, value);
            if (frequency > modeFrequency) {
                modeFrequency = frequency;
                modeValue = value;
            }
        }
        return modeValue;
    }

    // Precondition: Array "values" must not be empty.
    public double mode3(double[] values) {
        double modeValue = Double.NaN;
        int modeFrequency = 0;
        for (double value : values) {
            if (value != modeValue) {
                int frequency = countOccurrences(values, value);
                if (frequency > modeFrequency) {
                    modeFrequency = frequency;
                    modeValue = value;
                }
            }
        }
        return modeValue;
    }

    public void reverseInPlace(int[] values) {
        for (int i=0, n=values.length; i<n/2; i++) {
            int temp = values[i];
            values[i] = values[n-i-1];
            values[n-i-1] = temp;
        }
    }

    public void reverseInPlace2(int[] values) {
        for (int i=0, j=values.length-1; i<j; i++, j--) {
            int temp = values[i];
            values[i] = values[j];
            values[j] = temp;
        }
    }

    public void swap(int[] values, int i, int j) {
        int temp = values[i];
        values[i] = values[j];
        values[j] = temp;
    }

    public void reverseInPlace3(int[] values) {
        for (int i=0, j=values.length-1; i<j; i++, j--) {
            swap(values, i, j);
        }
    }

    public int[] reversedCopy(int[] values) {
        int n = values.length;
        int[] result = new int[n];
        for (int i=0; i<n; i++) {
            result[i] = values[n-i-1];
        }
        return result;
    }

    public int[] reversedCopy2(int[] values) {
        int n = values.length;
        int[] result = new int[n];
        for (int i=0, j=n-1; i<n; i++, j--) {
            result[i] = values[j];
        }
        return result;
    }

    public int[] reversedCopy3(int[] values) {
        int[] result = Arrays.copyOf(values, values.length);
        reverseInPlace(result);
        return result;
    }

    // Precondition: Array "values" be sorted and non-empty.
    public double modeOfSortedArray(double[] values) {
        double modeValue = values[0];
        int frequency = 1, modeFrequency = 1;
        for (int i=1, n=values.length; i<n; i++) {
            boolean sameAsLast = values[i-1] == values[i];
            if (sameAsLast) {
                frequency++;
            }
            if (frequency > modeFrequency) {
                modeFrequency = frequency;
                modeValue = values[i-1];
            }
            if (!sameAsLast) {
                frequency = 1;
            }
        }
        return modeValue;
    }

    public int lengthOfRun(double[] values, int index) {
        double value = values[index];
        int length = 0;
        while (index < values.length && values[index] == value) {
            index++;
            length++;
        }
        return length;
    }

    // Precondition: Array "values" must be sorted.
    public double modeOfSortedArray2(double[] values) {
        double modeValue = Double.NaN;
        int modeFrequency = 0;
        int i = 0;
        while (i < values.length) {
            int frequency = lengthOfRun(values, i);
            if (frequency > modeFrequency) {
                modeFrequency = frequency;
                modeValue = values[i];
            }
            i += frequency;
        }
        return modeValue;
    }
    
    class ModeAndFrequency {
        private double value;
        private int frequency;

        public ModeAndFrequency(double value, int frequency) {
            this.value = value;
            this.frequency = frequency;
        }

        public double getValue() { return value; }
        public int getFrequency() { return frequency; }
        public String toString() { return "mode=" + value + " frequency=" + frequency; }
    }

    public ModeAndFrequency modeAndFrequency(double[] values) {
        double modeValue = Double.NaN;
        int modeFrequency = 0;
        for (int i=0, n=values.length; i<n; i++) {
            double value = values[i];
            if (value != modeValue) {
                int frequency = 0;
                for (int j=0; j<n; j++) {
                    if (values[j] == value) {
                        frequency++;
                    }
                }
                if (frequency > modeFrequency) {
                    modeFrequency = frequency;
                    modeValue = value;
                }
            }
        }
        if (modeFrequency > 0) {
            return new ModeAndFrequency(modeValue, modeFrequency);
        } else {
            return null;
        }
    }

    public int countOccurrences(double[] values, double searchValue) {
        int count = 0;
        for (double value : values) {
            if (value == searchValue) {
                count++;
            }
        }
        return count;
    }

    public ModeAndFrequency modeAndFrequency2(double[] values) {
        double modeValue = Double.NaN;
        int modeFrequency = 0;
        for (int i=0, n=values.length; i<n; i++) {
            double value = values[i];
            if (value != modeValue) {
                int frequency = countOccurrences(values, value);
                if (frequency > modeFrequency) {
                    modeFrequency = frequency;
                    modeValue = value;
                }
            }
        }
        if (modeFrequency > 0) {
            return new ModeAndFrequency(modeValue, modeFrequency);
        } else {
            return null;
        }
    }

    // Precondition: Array cannot be empty.
    int findMinValue(int[] array) {
        int minValue = array[0];
        for (int i = 1, n = array.length; i < n; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
            }
        }
        return minValue;
    }

    // Precondition: Array cannot be empty.
    int findMaxValue(int[] array) {
        int maxValue = array[0];
        for (int i = 1, n = array.length; i < n; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }
        return maxValue;
    }

    // Precondition: Array cannot be empty.
    int findMinValue2(int[] array) {
        int minValue = Integer.MAX_VALUE;
        for (int value : array) {
            if (value < minValue) {
                minValue = value;
            }
        }
        return minValue;
    }

    // Precondition: Array cannot be empty.
    int findMaxValue2(int[] array) {
        int maxValue = Integer.MIN_VALUE;
        for (int value : array) {
            if (value > maxValue) {
                maxValue = value;
            }
        }
        return maxValue;
    }

    Integer findMinValue3(int[] array) {
        if (array.length == 0) {
            return null;
        }
        int minValue = Integer.MAX_VALUE;
        for (int value : array) {
            if (value < minValue) {
                minValue = value;
            }
        }
        return minValue;
    }
    
    Integer findMaxValue3(int[] array) {
        if (array.length == 0) {
            return null;
        }
        int maxValue = Integer.MIN_VALUE;
        for (int value : array) {
            if (value > maxValue) {
                maxValue = value;
            }
        }
        return maxValue;
    }
    
    // Precondition: Array cannot be empty.
    int indexOfMinValue(int[] array) {
        int minIndex = 0;
        for (int i = 1, n = array.length; i < n; i++) {
            if (array[i] < array[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    // No preconditions... I return -1 for empty arrays.
    int indexOfMinValue2(int[] array) {
        if (array.length == 0) {
            return -1;
        }
        int minIndex = 0;
        for (int i = 1, n = array.length; i < n; i++) {
            if (array[i] < array[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    boolean isAnyoneYoungerThan(Student[] students, int age) {
        for (Student student : students) {
            if (student.getAge() < age) {
                return true;
            }
        }
        return false;
    }

    // Precondition: Students must be a non-empty array.
    boolean isEveryoneAgeOrOlder(Student[] students, int minAge) {
        for (Student student : students) {
            if (student.getAge() < minAge) {
                return false;
            }
        }
        return true;
    }

    boolean isEveryoneAgeOrOlder2(Student[] students, int minAge) {
        return !isAnyoneYoungerThan(students, minAge);
    }

    Student findYoungestStudent(Student[] students) {
        Student youngestStudent = null;
        for (Student student : students) {
            if (youngestStudent == null) {
                youngestStudent = student;
            } else if (student.getAge() < youngestStudent.getAge()) {
                youngestStudent = student;
            }
        }
        return youngestStudent;
    }      

    public static void main(String args[]) {
        new ArrayAlgorithms().run();
    }

    public void run() {
        double a[] = { 1, 3, 1, 9, 1, 5, 17, 21, 30, 5, 0, 1};
        System.out.println(sum(a));
        System.out.println(average(a));
        System.out.println(averageStudentAge(students));
        System.out.println(Arrays.toString(getStudentAges(students)));
        System.out.println(averageStudentAge2(students));
        System.out.println(median(a));
        System.out.println(medianStudentAge(students));
        System.out.println(mode(a));
        System.out.println("modeAndFrequency(a) = " + modeAndFrequency(a));
        System.out.println("modeOfSortedArray(sorted(a)) = " + modeOfSortedArray(sortedCopyOfArray(a)));
        System.out.println("modeOfSortedArray2(sorted(a)) = " + modeOfSortedArray2(sortedCopyOfArray(a)));
        int index = 0;
        while ((index = indexOfStudentWithLastName(students, "Smith", index)) != -1) {
            System.out.println(students[index]);
            index++;
        }

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(copyRotatedLeft(a, 3)));
    }
}