package com.bridgelabz.linecomparison;

public class CheckLineEquality {
    private double x1, y1, x2, y2;

    // Constructor to initialize the line with two points

    public CheckLineEquality(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    // Overriding the equals method to compare two lines based on their endpoints
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        CheckLineEquality otherLine = (CheckLineEquality) obj;

        // Check if both lines have the same endpoints in any order
        return (this.x1 == otherLine.x1 && this.y1 == otherLine.y1 &&
                this.x2 == otherLine.x2 && this.y2 == otherLine.y2) ||
                (this.x1 == otherLine.x2 && this.y1 == otherLine.y2 &&
                        this.x2 == otherLine.x1 && this.y2 == otherLine.y1);
    }

    // Override hashCode method as well whenever equals is overridden
    @Override
    public int hashCode() {
        return Double.hashCode(x1 + y1 + x2 + y2);
    }
    public static void main(String[] args) {

// Creating two lines with the same endpoints
        CheckLineEquality line1 = new CheckLineEquality(1, 2, 4, 6);
        CheckLineEquality line2 = new CheckLineEquality(1, 2, 4, 6);

        // Creating another line with reversed endpoints
        CheckLineEquality line3 = new CheckLineEquality(4, 6, 1, 2);

        // Creating a line with different endpoints
        CheckLineEquality line4 = new CheckLineEquality(2, 3, 5, 7);

        // Check if line1 equals line2 (should be true)
        System.out.println("Line 1 equals Line 2: " + line1.equals(line2));

        // Check if line1 equals line3 (should be true because endpoints are the same but reversed)
        System.out.println("Line 1 equals Line 3: " + line1.equals(line3));

        // Check if line1 equals line4 (should be false)
        System.out.println("Line 1 equals Line 4: " + line1.equals(line4));

    }
}
