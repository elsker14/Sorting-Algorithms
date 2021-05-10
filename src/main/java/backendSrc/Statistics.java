package backendSrc;

import objectClasses.SortAlgo;
import objectClasses.Student;

import java.util.*;

public class Statistics {

    //Study case regarding which Sorting Algorithm is the fastest => Collection.sort WINNER!!
    private static boolean ASC = true;
    private static boolean DESC = false;

    public static void main(String[] args) {

        List<Student> studentsDB = new ArrayList<>();
        studentsDB = Student.hardcodeStudents();

        Map<String, Integer> performanceStatiticsOfSortAlgorithms = new HashMap<>();
        performanceStatiticsOfSortAlgorithms = Student.fillInSortAlgorithmStatistics();

        for (int i = 0; i < 100; i++)
        {
            SortAlgo bestSortAlgoPerIteration = new SortAlgo();

            // Sortare cu Collection.sort ----------------------------------------------------------------------------------
            long durationOfCollectionSort = Student.collectionSort(studentsDB);
            bestSortAlgoPerIteration.setSortingAlgoName("Collection.sort");
            bestSortAlgoPerIteration.setDuration(durationOfCollectionSort);

            // Sortare cu List.sort ----------------------------------------------------------------------------------------
            Collections.shuffle(studentsDB);
            long durationOfListSort = Student.listSort(studentsDB);
            bestSortAlgoPerIteration = (durationOfListSort < bestSortAlgoPerIteration.getDuration()
                    ? new SortAlgo("List.sort", durationOfListSort) : bestSortAlgoPerIteration);

            // Sortare cu QuickSort ----------------------------------------------------------------------------------------
            Collections.shuffle(studentsDB);
            long durationOfQuickSort = Student.quickSort(studentsDB);
            bestSortAlgoPerIteration = (durationOfQuickSort < bestSortAlgoPerIteration.getDuration()
                    ? new SortAlgo("QuickSort", durationOfQuickSort) : bestSortAlgoPerIteration);

            // Sortare cu HeapSort -----------------------------------------------------------------------------------------
            Collections.shuffle(studentsDB);
            long durationOfHeapSort = Student.heapSort(studentsDB);
            bestSortAlgoPerIteration = (durationOfHeapSort < bestSortAlgoPerIteration.getDuration()
                    ? new SortAlgo("HeapSort", durationOfHeapSort) : bestSortAlgoPerIteration);

            // Sortare cu MergeSort ----------------------------------------------------------------------------------------
            Collections.shuffle(studentsDB);
            long durationOfMergeSort = Student.mergeSort(studentsDB);
            bestSortAlgoPerIteration = (durationOfMergeSort < bestSortAlgoPerIteration.getDuration()
                    ? new SortAlgo("MergeSort", durationOfMergeSort) : bestSortAlgoPerIteration);

            // Sortare cu SelectionSort ------------------------------------------------------------------------------------
            Collections.shuffle(studentsDB);
            long durationOfSelectionSort = Student.selectionSort(studentsDB);
            bestSortAlgoPerIteration = (durationOfSelectionSort < bestSortAlgoPerIteration.getDuration()
                    ? new SortAlgo("SelectionSort", durationOfSelectionSort) : bestSortAlgoPerIteration);

            // Sortare cu InsertionSort ------------------------------------------------------------------------------------
            Collections.shuffle(studentsDB);
            long durationOfInsertionSort = Student.insertionSort(studentsDB);
            bestSortAlgoPerIteration = (durationOfInsertionSort < bestSortAlgoPerIteration.getDuration()
                    ? new SortAlgo("InsertionSort", durationOfInsertionSort) : bestSortAlgoPerIteration);

            // Sortare cu BubbleSort ---------------------------------------------------------------------------------------
            Collections.shuffle(studentsDB);
            long durationOfBubbleSort = Student.bubbleSort(studentsDB);
            bestSortAlgoPerIteration = (durationOfBubbleSort < bestSortAlgoPerIteration.getDuration()
                    ? new SortAlgo("BubbleSort", durationOfBubbleSort) : bestSortAlgoPerIteration);

            //Performance Comparison ---------------------------------------------------------------------------------------
            Integer counter = performanceStatiticsOfSortAlgorithms.get(bestSortAlgoPerIteration.getSortingAlgoName());
            performanceStatiticsOfSortAlgorithms.put(bestSortAlgoPerIteration.getSortingAlgoName(), counter + 1);
        }

        //Print Map ----------------------------------------------------------------------------------------------------
        //System.out.println();
        System.out.println("backendSrc.Statistics regarding which Sorting Algorithm is faster: ");
        System.out.println();

        performanceStatiticsOfSortAlgorithms = Student.sortByValue(performanceStatiticsOfSortAlgorithms, DESC);
        performanceStatiticsOfSortAlgorithms.forEach((key, value) -> System.out.println(key + " was " + value + " times faster than the others"));

        //Print List----------------------------------------------------------------------------------------------------
        System.out.println();
        //System.out.println();
        //studentsDB.stream().forEach(System.out::println);
    }
}
