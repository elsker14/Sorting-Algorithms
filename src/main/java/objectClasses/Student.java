package objectClasses;

import sortingAlgorithms.*;

import java.util.*;
import java.util.stream.Collectors;

public class Student {
    //Fields -----------------------------------------------------------------------------------------------------------
    private String nume;
    private String prenume;
    private String grupa;
    private String serie;
    private Integer an;
    private Double medie;
    private Boolean eligibilCamin;

    //Constructor ------------------------------------------------------------------------------------------------------
    public Student(String nume, String prenume, String grupa, String serie, Integer an, Double medie) {
        this.nume = nume;
        this.prenume = prenume;
        this.grupa = grupa;
        this.serie = serie;
        this.an = an;
        this.medie = medie;
    }

    //GETTERs && SETTERs -----------------------------------------------------------------------------------------------
    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getGrupa() {
        return grupa;
    }

    public void setGrupa(String grupa) {
        this.grupa = grupa;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Integer getAn() {
        return an;
    }

    public void setAn(Integer an) {
        this.an = an;
    }

    public Double getMedie() {
        return medie;
    }

    public void setMedie(Double medie) {
        this.medie = medie;
    }

    public Boolean getEligibilCamin() {
        return eligibilCamin;
    }

    public void setEligibilCamin(Boolean eligibilCamin) {
        this.eligibilCamin = eligibilCamin;
    }

    //toString
    @Override
    public String toString() {
        return  ("nume='" + nume +
                ", prenume='" + prenume +
                ", grupa='" + grupa +
                ", serie='" + serie +
                ", an=" + an +
                ", medie=" + medie);
    }

    //Methods ----------------------------------------------------------------------------------------------------------
    public static List <Student> hardcodeStudents()
    {
        List <Student> hardcodedListOfStudents = new ArrayList<>();
        Random rand = new Random();

        for(int i = 0; i < 1000; i++)
        {
            hardcodedListOfStudents.add(new Student(
                    RandomAlphaNumericString.getAlphaNumericString(5),
                    RandomAlphaNumericString.getAlphaNumericString(5),
                    RandomAlphaNumericString.getAlphaNumericString(3),
                    RandomAlphaNumericString.getAlphaNumericString(1),
                    ((int) (Math.random() * (5 - 1)) + 1),
                    (1D + (10D - 1D) * rand.nextDouble())
            ));
        }

        return hardcodedListOfStudents;
    }

    public static Map<String, Integer> sortByValue(Map<String, Integer> unsortMap, final boolean order)
    {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(unsortMap.entrySet());

        // Sorting the list based on values
        list.sort((o1, o2) -> order ? o1.getValue().compareTo(o2.getValue()) == 0
                ? o1.getKey().compareTo(o2.getKey())
                : o1.getValue().compareTo(o2.getValue()) : o2.getValue().compareTo(o1.getValue()) == 0
                ? o2.getKey().compareTo(o1.getKey())
                : o2.getValue().compareTo(o1.getValue()));
        return list.stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b, LinkedHashMap::new));

    }


    public static Map <String, Integer> fillInSortAlgorithmStatistics()
    {
        Map<String, Integer> performanceStatiticsOfSortAlgorithms = new HashMap<>();

        performanceStatiticsOfSortAlgorithms.put("Collection.sort", 0);
        performanceStatiticsOfSortAlgorithms.put("List.sort", 0);
        performanceStatiticsOfSortAlgorithms.put("QuickSort", 0);
        performanceStatiticsOfSortAlgorithms.put("HeapSort", 0);
        performanceStatiticsOfSortAlgorithms.put("MergeSort", 0);
        performanceStatiticsOfSortAlgorithms.put("SelectionSort", 0);
        performanceStatiticsOfSortAlgorithms.put("InsertionSort", 0);
        performanceStatiticsOfSortAlgorithms.put("BubbleSort", 0);

        return performanceStatiticsOfSortAlgorithms;
    }

    //Sorting Algorithms
    public static long collectionSort(List <Student> tmp)
    {
        long timeStarted, timeEnded;

        timeStarted = System.nanoTime();
        Collections.sort(tmp, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.getMedie().compareTo(o1.getMedie());
            }
        });
        timeEnded = System.nanoTime();
        //System.out.println("Collection.sort: sorting time => " + (timeEnded - timeStarted) + " ns");
        return (timeEnded - timeStarted);
    }

    public static long listSort(List <Student> tmp)
    {
        long timeStarted, timeEnded;

        timeStarted = System.nanoTime();
        tmp.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.getMedie().compareTo(o1.getMedie());
            }
        });
        timeEnded = System.nanoTime();
        //System.out.println("List.sort: sorting time => " + (timeEnded - timeStarted) + " ns");
        return (timeEnded - timeStarted);
    }

    public static long quickSort(List <Student> tmp)
    {
        long timeStarted, timeEnded;

        timeStarted = System.nanoTime();
        QuickSort.quickSort(tmp, 0, tmp.size() - 1);
        timeEnded = System.nanoTime();
        //System.out.println("QuickSort: sorting time => " + (timeEnded - timeStarted) + " ns");
        return (timeEnded - timeStarted);
    }

    public static long heapSort(List <Student> tmp)
    {
        long timeStarted, timeEnded;

        timeStarted = System.nanoTime();
        HeapSort.heapSort(tmp);
        timeEnded = System.nanoTime();
        //System.out.println("HeapSort: sorting time => " + (timeEnded - timeStarted) + " ns");
        return (timeEnded - timeStarted);
    }

    public static long mergeSort(List <Student> tmp)
    {
        long timeStarted, timeEnded;

        timeStarted = System.nanoTime();
        MergeSort.mergeSort(tmp, 0, tmp.size() - 1);
        timeEnded = System.nanoTime();
        //System.out.println("MergeSort: sorting time => " + (timeEnded - timeStarted) + " ns");
        return (timeEnded - timeStarted);
    }

    public static long selectionSort(List <Student> tmp)
    {
        long timeStarted, timeEnded;

        timeStarted = System.nanoTime();
        SelectionSort.selectionSort(tmp);
        timeEnded = System.nanoTime();
        //System.out.println("SelectionSort: sorting time => " + (timeEnded - timeStarted) + " ns");
        return (timeEnded - timeStarted);
    }

    public static long insertionSort(List <Student> tmp)
    {
        long timeStarted, timeEnded;

        timeStarted = System.nanoTime();
        InsertionSort.insertionSort(tmp);
        timeEnded = System.nanoTime();
        //System.out.println("InsertionSort: sorting time => " + (timeEnded - timeStarted) + " ns");
        return (timeEnded - timeStarted);
    }

    public static long bubbleSort(List <Student> tmp)
    {
        long timeStarted, timeEnded;

        timeStarted = System.nanoTime();
        BubbleSort.bubbleSort(tmp);
        timeEnded = System.nanoTime();
        //System.out.println("BubbleSort: sorting time => " + (timeEnded - timeStarted) + " ns");
        return (timeEnded - timeStarted);
    }
}

