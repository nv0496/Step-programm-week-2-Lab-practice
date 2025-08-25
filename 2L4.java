public class StringPerformanceComparison {
    public static void main(String[] args) {
        System.out.println("=== PERFORMANCE COMPARISON ===");

        long startTime = System.nanoTime();
        String result1 = concatenateWithString(1000);
        long endTime = System.nanoTime();
        System.out.println("String concatenation time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        String result2 = concatenateWithStringBuilder(1000);
        endTime = System.nanoTime();
        System.out.println("StringBuilder concatenation time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        String result3 = concatenateWithStringBuffer(1000);
        endTime = System.nanoTime();
        System.out.println("StringBuffer concatenation time: " + (endTime - startTime) + " ns");

        demonstrateStringBuilderMethods();
        demonstrateThreadSafety();
        compareStringComparisonMethods();
        demonstrateMemoryEfficiency();
    }

    public static String concatenateWithString(int iterations) {
        String result = "";
        for (int i = 0; i < iterations; i++) {
            result += "Java " + i + " ";
        }
        return result;
    }

    public static String concatenateWithStringBuilder(int iterations) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append("Java ").append(i).append(" ");
        }
        return sb.toString();
    }

    public static String concatenateWithStringBuffer(int iterations) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sb.append("Java ").append(i).append(" ");
        }
        return sb.toString();
    }

    public static void demonstrateStringBuilderMethods() {
        System.out.println("\n=== StringBuilder Methods ===");
        StringBuilder sb = new StringBuilder("Hello World");
        sb.append(" Java");
        System.out.println("append: " + sb);
        sb.insert(6, "Beautiful ");
        System.out.println("insert: " + sb);
        sb.delete(6, 16);
        System.out.println("delete: " + sb);
        sb.deleteCharAt(5);
        System.out.println("deleteCharAt: " + sb);
        sb.reverse();
        System.out.println("reverse: " + sb);
        sb.reverse();
        sb.replace(0, 5, "Hi");
        System.out.println("replace: " + sb);
        sb.setCharAt(3, 'X');
        System.out.println("setCharAt: " + sb);
        System.out.println("capacity: " + sb.capacity());
        sb.ensureCapacity(100);
        System.out.println("capacity after ensureCapacity(100): " + sb.capacity());
        sb.trimToSize();
        System.out.println("capacity after trimToSize: " + sb.capacity());
    }

    public static void demonstrateThreadSafety() {
        System.out.println("\n=== Thread Safety Demo ===");
        StringBuffer sbuf = new StringBuffer("Start");
        Runnable task = () -> {
            for (int i = 0; i < 5; i++) {
                sbuf.append("X");
            }
        };
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {}
        System.out.println("StringBuffer after threads: " + sbuf);
    }

    public static void compareStringComparisonMethods() {
        System.out.println("\n=== String Comparison Methods ===");
        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = new String("Hello");

        System.out.println("str1 == str2: " + (str1 == str2));
        System.out.println("str1 == str3: " + (str1 == str3));
        System.out.println("str1.equals(str3): " + str1.equals(str3));
        System.out.println("str1.equalsIgnoreCase(\"hello\"): " + str1.equalsIgnoreCase("hello"));
        System.out.println("str1.compareTo(str3): " + str1.compareTo(str3));
        System.out.println("str1.compareToIgnoreCase(\"hello\"): " + str1.compareToIgnoreCase("hello"));
    }

    public static void demonstrateMemoryEfficiency() {
        System.out.println("\n=== Memory Efficiency Demo ===");
        Runtime runtime = Runtime.getRuntime();
        long before = runtime.freeMemory();
        String s1 = "Java";
        String s2 = "Java";
        String s3 = new String("Java");
        long after = runtime.freeMemory();
        System.out.println("Memory used for String creation: " + (before - after));
        StringBuilder sb = new StringBuilder();
        System.out.println("Initial capacity: " + sb.capacity());
        for (int i = 0; i < 100; i++) sb.append("Test");
        System.out.println("Capacity after appending: " + sb.capacity());
        sb.trimToSize();
        System.out.println("Capacity after trimToSize: " + sb.capacity());
    }
}
