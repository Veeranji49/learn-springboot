package com.example.Controller;

import com.example.model.Addition;
import com.example.model.Average;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.*;

import static org.aspectj.util.FileUtil.deleteContents;

@RestController
@RequestMapping(value="/api/v1/practice")
public class APIController {

    //**    http://localhost:9999/springboot_restapi/api/v1/practice/api1  **//
    @GetMapping(value = "/api1")
    public String msg() {
        return "Hello welcome to Spring Boot REST API";
    }

    //**    http://localhost:9999/springboot_restapi/api/v1/practice/api2  **//
    @PostMapping(value = "/api2")
    public int addition1(@RequestBody Addition addition) {
        return addition.getA() + addition.getB();
    }

    //  Testing from URL  *** Body = none  ***
    //  http://localhost:9999/springboot_restapi/api/v1/practice/api3?a=67&b=90
    @PostMapping(value = "/api3")
    public int addition2(@RequestParam int a, @RequestParam int b) {
        return a + b;
    }

    // http://localhost:9999/springboot_restapi/api/v1/practice/average  //
    @PostMapping(value="/average")
    public double calculateAverage(@RequestBody Average average) {
        return (average.getNumber1() + average.getNumber2() + average.getNumber3()) / 3.0;
    }

    //**   http://localhost:9999/springboot_restapi/api/v1/practice/check-palindrome?input=racecar   **//
    @PostMapping(value="/check-palindrome")
    public boolean checkPalindrome(@RequestParam String input) {
        String reversed = new StringBuilder(input).reverse().toString();
        return input.equalsIgnoreCase(reversed);
    }

    //**  http://localhost:9999/springboot_restapi/api/v1/practice/reverse-string?input=hello   **//
    @PostMapping(value="/reverse-string")
    public String reverseString(@RequestParam String input) {
        return new StringBuilder(input).reverse().toString();
    }

    //**  http://localhost:9999/springboot_restapi/api/v1/practice/exponential?base=2&exponent=5   **//
    @PostMapping(value="/exponential")
    public double calculateExponential(@RequestParam double base, @RequestParam double exponent) {
        return Math.pow(base, exponent);
    }

    //**  http://localhost:9999/springboot_restapi/api/v1/practice/square-root?number=144  **//
    @GetMapping(value="/square-root")
    public double calculateSquareRoot(@RequestParam double number) {
        return Math.sqrt(number);
    }

    //   This class provides methods for generating universally unique identifiers (UUIDs).
    //**  http://localhost:9999/springboot_restapi/api/v1/practice/generate-uuid  **//
    @GetMapping(value="/generate-uuid")
    public String generateUUID() {
        return UUID.randomUUID().toString();
    }

    //**   http://localhost:9999/springboot_restapi/api/v1/practice/string-length?input=anji   **//
    @GetMapping(value="/string-length")
    public int getStringLength(@RequestParam String input) {
        return input.length();
    }

    //**   http://localhost:9999/springboot_restapi/api/v1/practice/triangle-perimeter?side1=23&side2=37&side3=56
    @GetMapping(value="/triangle-perimeter")
    public double calculateTrianglePerimeter(@RequestParam double side1, @RequestParam double side2, @RequestParam double side3) {
        return side1 + side2 + side3;
    }

    //***   http://localhost:9999/springboot_restapi/api/v1/practice/simple-interest?principal=10000&rate=2&time=12
    @GetMapping(value="/simple-interest")
    public double calculateSimpleInterest(@RequestParam double principal, @RequestParam double rate, @RequestParam int time) {
        return (principal * rate * time) / 100;
    }

    //**   http://localhost:9999/springboot_restapi/api/v1/practice/rectangle-area?length=50.0&width=50.0
    @GetMapping(value="/rectangle-area")
    public double calculateRectangleArea(@RequestParam double length, @RequestParam double width) {
        return length * width;
    }

    //**   http://localhost:9999/springboot_restapi/api/v1/practice/leap-year?year=2024
    @GetMapping(value="/leap-year")
    public boolean isLeapYear(@RequestParam int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Calculate BMI (Body Mass Index)
    //**  http://localhost:9999/springboot_restapi/api/v1/practice/bmi?weight=58&height=1.78
    @GetMapping(value="/bmi")
    public double calculateBMI(@RequestParam double weight, @RequestParam double height) {
        return weight / (height * height);
    }

    //**   http://localhost:9999/springboot_restapi/api/v1/practice/century-year?year=2000
    @GetMapping(value="/century-year")
    public boolean isCenturyYear(@RequestParam int year) {
        return year % 100 == 0;
    }

    //  http://localhost:9999/springboot_restapi/api/v1/practice/binary-to-decimal?binary=1100
    @GetMapping(value="/binary-to-decimal")
    public int binaryToDecimal(@RequestParam String binary) {
        return Integer.parseInt(binary, 2);
    }

    //**    http://localhost:9999/springboot_restapi/api/v1/practice/decimal-to-binary?decimal=12
    @GetMapping(value="/decimal-to-binary")
    public String decimalToBinary(@RequestParam int decimal) {
        return Integer.toBinaryString(decimal);
    }

    //  This request will return the size of the specified file in bytes
    // The FileSystem object representing the local file system.
    //**   http://localhost:9999/springboot_restapi/api/v1/practice/file-size?filePath=/C:/Users/mwin2/Downloads/Springboot APIs.zip
    @GetMapping(value="/file-size")
    public long getFileSize(@RequestParam String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists())
            throw new IllegalArgumentException("File does not exist");
        return Files.size(file.toPath());
    }


    //  This request will return the content of specified file
    //**   http://localhost:9999/springboot_restapi/api/v1/practice/file-content?filePath=C:/Windows/System32/drivers/etc/hosts   **//
    @GetMapping(value="/file-content")
    public String getFileContent(@RequestParam String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists())
            throw new IllegalArgumentException("File does not exist");
        byte[] bytes = Files.readAllBytes(file.toPath());
        return new String(bytes);
    }

    //**   http://localhost:9999/springboot_restapi/api/v1/practice/reverse-list?numbers=1,3,343,23,4  **//
    @PostMapping(value="/reverse-list")
    public List<Integer> reverseList(@RequestParam List<Integer> numbers) {
        Collections.reverse(numbers);
        return numbers;
    }

    //**   http://localhost:9999/springboot_restapi/api/v1/practice/find-max?numbers=5,2,8,1,9   **//
    @PostMapping(value="/find-max")
    public int findMax(@RequestParam List<Integer> numbers) {
        return Collections.max(numbers);
    }

    //**   http://localhost:9999/springboot_restapi/api/v1/practice/find-min?numbers=5,2,8,1,9   **//
    @PostMapping(value="/find-min")
    public int findMin(@RequestParam List<Integer> numbers) {
        return Collections.min(numbers);
    }

    //**   http://localhost:9999/springboot_restapi/api/v1/practice/weekday?date=2024-04-24
    //LocalDate is an immutable date-time object that represents a date
    @GetMapping(value="/weekday")
    public String getWeekday(@RequestParam String date) {
        LocalDate parsedDate = LocalDate.parse(date);
        DayOfWeek dayOfWeek = parsedDate.getDayOfWeek();
        return dayOfWeek.toString();
    }

    //   0.621371 is the conversion factor used to convert kilometers to miles.
    //**   http://localhost:9999/springboot_restapi/api/v1/practice/kilometers-to-miles?kilometers=5
    @GetMapping(value="/kilometers-to-miles")
    public double convertKilometersToMiles(@RequestParam double kilometers) {
        return kilometers * 0.621371;
    }

    // 1 mile = 1.60934 kilometer
    //**  http://localhost:9999/springboot_restapi/api/v1/practice/miles-to-kilometers?miles=5
    @GetMapping(value="/miles-to-kilometers")
    public double convertMilesToKilometers(@RequestParam double miles) {
        return miles * 1.60934;
    }

    /* The class Math contains methods for performing basic numeric operations such as the elementary exponential,
        logarithm, square root, and trigonometric functions.  */
    //**   http://localhost:9999/springboot_restapi/api/v1/practice/is-perfect-square/25   **//
    @GetMapping(value="/is-perfect-square/{number}")
    public boolean isPerfectSquare(@PathVariable("number") int number) {
        int sqrt = (int) Math.sqrt(number);
        return sqrt * sqrt == number;
    }

    //**   http://localhost:9999/springboot_restapi/api/v1/practice/sum-of-first-n-natural-numbers?n=5   **//
    @GetMapping(value="/sum-of-first-n-natural-numbers")
    public int sumOfFirstNNaturalNumbers(@RequestParam int n) {
        return n * (n + 1) / 2;
    }


    //**   http://localhost:9999/springboot_restapi/api/v1/practice/find-middle-element?numbers=1,2,3,4,5   **//
    @GetMapping(value="/find-middle-element")
    public int findMiddleElement(@RequestParam int[] numbers) {
        Arrays.sort(numbers);
        return numbers[numbers.length / 2];
    }

    //**   http://localhost:9999/springboot_restapi/api/v1/practice/merge-arrays?array1=1,2,3&array2=4,5,6   **//
    @GetMapping(value="/merge-arrays")
    public List<Integer> mergeArrays(@RequestParam List<Integer> array1, @RequestParam List<Integer> array2) {
        List<Integer> mergedArray = new ArrayList<>(array1);
        mergedArray.addAll(array2);
        return mergedArray;
    }

    //**   http://localhost:9999/springboot_restapi/api/v1/practice/find-majority-element?numbers=2,2,3,4,2,5,2,2,2   **//
    @GetMapping(value="/find-majority-element")
    public int findMajorityElement(@RequestParam int[] numbers) {
        Arrays.sort(numbers);
        int n = numbers.length;
        return numbers[n/2];
    }

    //**  http://localhost:9999/springboot_restapi/api/v1/practice/calculate-age?birthdate=2000-04-06
    @GetMapping(value="/calculate-age")
    public int calculateAge(@RequestParam String birthdate) {
        LocalDate dob = LocalDate.parse(birthdate);
        LocalDate currentDate = LocalDate.now();
        return Period.between(dob, currentDate).getYears();
    }

    //**   http://localhost:9999/springboot_restapi/api/v1/practice/calculate-days-between-dates?startDate=2000-04-06&endDate=2024-04-24
    @GetMapping(value="/calculate-days-between-dates")
    public long calculateDaysBetweenDates(@RequestParam String startDate, @RequestParam String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        return ChronoUnit.DAYS.between(start, end);
    }

    //**   http://localhost:9999/springboot_restapi/api/v1/practice/decimal-to-hexadecimal?decimal=100
    @GetMapping(value="/decimal-to-hexadecimal")
    public String decimalToHexadecimal(@RequestParam int decimal) {
        return Integer.toHexString(decimal);
    }

    //**  http://localhost:9999/springboot_restapi/api/v1/practice/hexadecimal-to-decimal?hexadecimal=100
    @GetMapping(value="/hexadecimal-to-decimal")
    public int hexadecimalToDecimal(@RequestParam String hexadecimal) {
        return Integer.parseInt(hexadecimal, 16);
    }

    //**  http://localhost:9999/springboot_restapi/api/v1/practice/decimal-to-octal?decimal=100
    @GetMapping(value="/decimal-to-octal")
    public String decimalToOctal(@RequestParam int decimal) {
        return Integer.toOctalString(decimal);
    }

    //**  http://localhost:9999/springboot_restapi/api/v1/practice/octal-to-decimal?octal=111
    @GetMapping(value="/octal-to-decimal")
    public int octalToDecimal(@RequestParam String octal) {
        return Integer.parseInt(octal, 8);
    }

    //**   http://localhost:9999/springboot_restapi/api/v1/practice/convert-to-uppercase?text=hello   **//
    @GetMapping(value="/convert-to-uppercase")
    public String convertToUppercase(@RequestParam String text) {
        return text.toUpperCase();
    }

    //**   http://localhost:9999/springboot_restapi/api/v1/practice/convert-to-lowercase?text=HELLO   **//
    @GetMapping(value="/convert-to-lowercase")
    public String convertToLowercase(@RequestParam String text) {
        return text.toLowerCase();
    }

    //**   http://localhost:9999/springboot_restapi/api/v1/practice/find-index-of-element?array=1,2,3,4,5&element=3   **//
    @GetMapping(value="/find-index-of-element")
    public int findIndexOfElement(@RequestParam List<Integer> array, @RequestParam int element) {
        return array.indexOf(element);
    }

    //**   http://localhost:9999/springboot_restapi/api/v1/practice/create-directory?directoryPath=C:/Users/mwin2/Desktop/mobile
    @PostMapping(value="/create-directory")
    public boolean createDirectory(@RequestParam String directoryPath) {
        File directory = new File(directoryPath);
        return directory.mkdir();
    }

    //**   http://localhost:9999/springboot_restapi/api/v1/practice/delete-file?filePath=C:/Users/mwin2/Desktop/mobile
    @DeleteMapping(value="/delete-file")
    public boolean deleteFile(@RequestParam String filePath) {
        File file = new File(filePath);
        return file.delete();
    }

    //**  http://localhost:9999/springboot_restapi/api/v1/practice/current-time
    @GetMapping("/current-time")
    public String getCurrentTime() {
        LocalDateTime now = LocalDateTime.now();
        return now.toString();
    }

    //**   http://localhost:9999/springboot_restapi/api/v1/practice/current-date
    @GetMapping(value="/current-date")
    public LocalDate getCurrentDate() {
        return LocalDate.now();
    }

    // Convert seconds to minutes
    //**   http://localhost:9999/springboot_restapi/api/v1/practice/seconds-to-minutes?seconds=360
    @GetMapping(value="/seconds-to-minutes")
    public double convertSecondsToMinutes(@RequestParam int seconds) {
        return seconds / 60.0;
    }

    // Convert minutes to hours
    //**    http://localhost:9999/springboot_restapi/api/v1/practice/minutes-to-hours?minutes=120
    @GetMapping(value="/minutes-to-hours")
    public double convertMinutesToHours(@RequestParam int minutes) {
        return minutes / 60.0;
    }

    // Convert hours to days
    //**   http://localhost:9999/springboot_restapi/api/v1/practice/hours-to-days?hours=48
    @GetMapping(value="/hours-to-days")
    public double convertHoursToDays(@RequestParam int hours) {
        return hours / 24.0;
    }

    // Convert days to weeks
    //**    http://localhost:9999/springboot_restapi/api/v1/practice/days-to-weeks?days=67
    @GetMapping(value="/days-to-weeks")
    public double convertDaysToWeeks(@RequestParam int days) {
        return days / 7.0;
    }

    // Convert kilograms to pounds
    //**    http://localhost:9999/springboot_restapi/api/v1/practice/kilograms-to-pounds?kilograms=60
    @GetMapping(value="/kilograms-to-pounds")
    public double convertKilogramsToPounds(@RequestParam double kilograms) {
        return kilograms * 2.20462;
    }

    // Convert pounds to kilograms
    //**    http://localhost:9999/springboot_restapi/api/v1/practice/pounds-to-kilograms?pounds=132
    @GetMapping(value="/pounds-to-kilograms")
    public double convertPoundsToKilograms(@RequestParam double pounds) {
        return pounds / 2.20462;
    }

    // Check if a number is an even number
    //**    http://localhost:9999/springboot_restapi/api/v1/practice/is-even?number=232
    @GetMapping(value="/is-even")
    public boolean isEven(@RequestParam int number) {
        return number % 2 == 0;
    }

    // Check if a number is an odd number
    //**    http://localhost:9999/springboot_restapi/api/v1/practice/is-odd?number=232
    @GetMapping(value="/is-odd")
    public boolean isOdd(@RequestParam int number) {
        return number % 2 != 0;
    }

    // Convert a temperature from Celsius to Fahrenheit
    //**    http://localhost:9999/springboot_restapi/api/v1/practice/celsius-to-fahrenheit?celsius=41
    @GetMapping(value="/celsius-to-fahrenheit")
    public double celsiusToFahrenheit(@RequestParam double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    // Convert a temperature from Fahrenheit to Celsius
    //**   http://localhost:9999/springboot_restapi/api/v1/practice/fahrenheit-to-celsius?fahrenheit=120
    @GetMapping(value="/fahrenheit-to-celsius")
    public double fahrenheitToCelsius(@RequestParam double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    //** http://localhost:9999/springboot_restapi/api/v1/practice/contains-substring?input=veeranji&substring=veer
    @GetMapping(value="/contains-substring")
    public boolean containsSubstring(@RequestParam String input, @RequestParam String substring) {
        return input.contains(substring);
    }

    //** http://localhost:9999/springboot_restapi/api/v1/practice/calculate-total-salary?basicSalary=1000&da=200&hra=300
    @GetMapping(value="calculate-total-salary")
    public double calculateTotalSalary(@RequestParam double basicSalary, @RequestParam double da,
                                       @RequestParam double hra) {
        return basicSalary + da + hra;
    }

    //**  http://localhost:9999/springboot_restapi/api/v1/practice/read-file?filePath=C:/Windows/System32/drivers/etc/hosts
    @GetMapping(value="/read-file")
    public String readFile(@RequestParam String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    //**  http://localhost:9999/springboot_restapi/api/v1/practice/write-file?filePath=  &content=
    @PostMapping(value="/write-file")
    public void writeFile(@RequestParam String filePath, @RequestParam String content) throws IOException {
        Files.write(Paths.get(filePath), content.getBytes());
    }

    //**  http://localhost:9999/springboot_restapi/api/v1/practice/list-files?directoryPath=C:/Users/mwin2/Desktop/
    @GetMapping(value="/list-files")
    public String[] listFiles(@RequestParam String directoryPath) {
        File directory = new File(directoryPath);
        return directory.list();
    }

    //**   http://localhost:9999/springboot_restapi/api/v1/practice/copy-file?sourcePath=C:/Users/mwin2/Desktop/dal-backend-api&destinationPath=C:/Users/mwin2/Desktop/veeranji
    @PostMapping(value="/copy-file")
    public void copyFile(@RequestParam String sourcePath, @RequestParam String destinationPath) throws IOException {
        Path source = Paths.get(sourcePath);
        Path destination = Paths.get(destinationPath);
        Files.copy(source, destination);
    }

   //** http://localhost:9999/springboot_restapi/api/v1/practice/move-file?sourcePath=C:/Users/mwin2/Desktop/dal-backend-api&destinationPath=C:/Users/mwin2/Desktop/veeranji
    @PostMapping(value="/move-file")
    public void moveFile(@RequestParam String sourcePath, @RequestParam String destinationPath) throws IOException {
        Path source = Paths.get(sourcePath);
        Path destination = Paths.get(destinationPath);
        Files.move(source, destination);
    }

    //**  http://localhost:9999/springboot_restapi/api/v1/practice/file-exists?filePath=C:/Windows/System32/drivers/etc/hosts
    @GetMapping(value="/file-exists")
    public boolean doesFileExist(@RequestParam String filePath) {
        File file = new File(filePath);
        return file.exists();
    }

    //**   http://localhost:9999/springboot_restapi/api/v1/practice/delete-directory?directoryPath=C:/Users/mwin2/Desktop/veeranji
    @DeleteMapping(value="/delete-directory")
    public void deleteDirectory(@RequestParam String directoryPath) {
        File directory = new File(directoryPath);
        if (directory.exists()) {
            deleteContents(directory);
            directory.delete();
        }
    }

    //**  http://localhost:9999/springboot_restapi/api/v1/practice/rename-directory?oldPath=C:/Users/mwin2/Desktop/veeranji
    @PutMapping(value="/rename-directory")
    public void renameDirectory(@RequestParam String oldPath, @RequestParam String newPath) {
        File oldDir = new File(oldPath);
        File newDir = new File(newPath);
        oldDir.renameTo(newDir);
    }

    //**   http://localhost:9999/springboot_restapi/api/v1/practice/directory-exists?directoryPath=C:/Users/mwin2/Desktop/veeranji
    @GetMapping(value="/directory-exists")
    public boolean doesDirectoryExist(@RequestParam String directoryPath) {
        File directory = new File(directoryPath);
        return directory.exists() && directory.isDirectory();
    }

    //**   http://localhost:9999/springboot_restapi/api/v1/practice/file-last-modified-time?filePath=C:/Users/mwin2/Desktop/veeranji
    @GetMapping(value="/file-last-modified-time")
    public long getFileLastModifiedTime(@RequestParam String filePath) {
        File file = new File(filePath);
        return file.lastModified();
    }

    //**   http://localhost:9999/springboot_restapi/api/v1/practice/is-file?path=C:/Users/mwin2/Desktop/veeranji
    //Checking if a given path corresponds to a file or a directory.
    @GetMapping(value="/is-file")
    public boolean isFile(@RequestParam String path) {
        File file = new File(path);
        return file.isFile();
    }

    //**    http://localhost:9999/springboot_restapi/api/v1/practice/is-directory?path=C:/Users/mwin2/Desktop/veeranji
    @GetMapping(value="/is-directory")
    public boolean isDirectory(@RequestParam String path) {
        File file = new File(path);
        return file.isDirectory();
    }

        //**   http://localhost:9999/springboot_restapi/api/v1/practice/sum-of-array?numbers=1,2,3,4,5   **//
    /*@PostMapping(value="/sum-of-array")
    public int calculateSumOfArray(@RequestParam List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }*/

    //**   http://localhost:9999/springboot_restapi/api/v1/practice/sort-array   **//
    /*@PutMapping(value="/sort-array")
    public int[] sortArray(@RequestBody int[] array) {
        Arrays.sort(array);
        return array;
    }*/

    //  http://localhost:9999/springboot_restapi/api/v1/practice/prime-numbers?start=50&end=100
   /* @GetMapping(value="/prime-numbers")
    public List<Integer> getPrimeNumbersInRange(@RequestParam int start, @RequestParam int end) {
        return primeNumberService.findPrimesInRange(start, end);
    }*/

}
