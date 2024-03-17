package LabSession1.Lab1.ex1;


import java.util.Scanner;

    public class ComplexCalculator {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Welcome to Complex Number Calculator!");
            System.out.println("Menu:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("Enter your choice (1/2/3):");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    performAddition();
                    break;
                case 2:
                    performSubtraction();
                    break;
                case 3:
                    performMultiplication();
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

            scanner.close();
        }

        private static void performAddition() {
            ComplexNumber num1 = new ComplexNumber(2, 5);
            ComplexNumber num2 = new ComplexNumber(4, -1);
            ComplexNumber result = num1.add(num2);
            System.out.println("Result of addition: " + result);
        }

        private static void performSubtraction() {
            ComplexNumber num1 = new ComplexNumber(2, 5);
            ComplexNumber num2 = new ComplexNumber(4, -1);
            ComplexNumber result = num1.subtract(num2);
            System.out.println("Result of subtraction: " + result);
        }

        private static void performMultiplication() {
            ComplexNumber num1 = new ComplexNumber(2, 5);
            ComplexNumber num2 = new ComplexNumber(4, -1);
            ComplexNumber result = num1.multiply(num2);
            System.out.println("Result of multiplication: " + result);
        }
    }

    class ComplexNumber {
        private double real;
        private double imaginary;

        public ComplexNumber(double real, double imaginary) {
            this.real = real;
            this.imaginary = imaginary;
        }

        public ComplexNumber add(ComplexNumber other) {
            return new ComplexNumber(this.real + other.real, this.imaginary + other.imaginary);
        }

        public ComplexNumber subtract(ComplexNumber other) {
            return new ComplexNumber(this.real - other.real, this.imaginary - other.imaginary);
        }

        public ComplexNumber multiply(ComplexNumber other) {
            double newReal = this.real * other.real - this.imaginary * other.imaginary;
            double newImaginary = this.real * other.imaginary + this.imaginary * other.real;
            return new ComplexNumber(newReal, newImaginary);
        }

        @Override
        public String toString() {
            return real + (imaginary >= 0 ? "+" : "") + imaginary + "i";
        }
    }

